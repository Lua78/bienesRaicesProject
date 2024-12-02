package com.api.globalState.services.interfaces;

import com.api.globalState.entities.FileEntity;

import java.util.List;

public interface IFilesService {

    FileEntity saveFile(String base64);

    List<FileEntity> saveFiles(List<String> base64);
}
