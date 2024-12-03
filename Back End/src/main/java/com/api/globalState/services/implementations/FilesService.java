package com.api.globalState.services.implementations;

import com.api.globalState.entities.FileEntity;
import com.api.globalState.repositories.FileRepository;
import com.api.globalState.services.interfaces.IFilesService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class FilesService implements IFilesService {
    private final FileRepository repository;

    @Value("${user.directory}")
    private String directory;

    public FilesService(FileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FileEntity> saveFiles(List<String> bases64) {
        List<FileEntity> entities = new ArrayList<>();
        for(String file : bases64){
            try {
                FileEntity entity = this.saveFile(file);
                entities.add(entity);
            }catch (RuntimeException e){
                log.info("Error creando el archivo: {}", e.getMessage());
            }
        }
        return entities;
    }

    @Override
    public FileEntity saveFile(String base64) {
        try {
            File dir = new File(directory);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new RuntimeException("No se pudo crear el directorio de almacenamiento: " + directory);
            }
            String[] parts = base64.split(",");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Formato Base64 inválido");
            }

            String metadata = parts[0];
            String base64Content = parts[1];

            String mimeType = metadata.split(";")[0].split(":")[1];

            String extension = getFileExtensionFromMimeType(mimeType);

            byte[] fileBytes = java.util.Base64.getDecoder().decode(base64Content);
            String fileName = "file_" + System.currentTimeMillis() + "." + extension;

            File file = new File(directory, fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileBytes);
            }

            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(fileName);
            fileEntity.setPath(file.getAbsolutePath());
            fileEntity.setType(mimeType);
            fileEntity.setActive(true);
            return repository.save(fileEntity);
        } catch (IOException | IllegalArgumentException e) {

            throw new RuntimeException("Error al guardar el archivo", e);
        }
    }
    public String getFileAsBase64(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("El archivo no existe: " + filePath);
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            String base64Content = Base64.getEncoder().encodeToString(fileBytes);

            String mimeType = getMimeType(file);

            return "data:" + mimeType + ";base64," + base64Content;
        } catch (IOException e) {
            log.error("Error al leer el archivo: {}", filePath, e);
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }

    private String getFileExtensionFromMimeType(String mimeType) {
        return switch (mimeType) {
            case "image/jpeg" -> "jpg";
            case "image/png" -> "png";
            case "application/pdf" -> "pdf";
            case "text/plain" -> "txt";
            case "application/json" -> "json";
            default -> "bin"; // Extensión por defecto para tipos desconocidos
        };
    }
    private String getMimeType(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        return switch (extension) {
            case "jpg", "jpeg" -> "image/jpeg";
            case "png" -> "image/png";
            case "pdf" -> "application/pdf";
            case "txt" -> "text/plain";
            case "json" -> "application/json";
            default -> "application/octet-stream"; // Tipo binario genérico
        };
    }

}
