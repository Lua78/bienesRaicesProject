package com.api.globalState.services.implementations;

import com.api.globalState.dtos.request.PropertyDto;
import com.api.globalState.dtos.response.PropertyResponseDto;
import com.api.globalState.entities.FileEntity;
import com.api.globalState.entities.auth.UserEntity;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.repositories.properties.PropertyRepository;
import com.api.globalState.services.interfaces.IPropertyService;
import com.api.globalState.utils.Jwt.JwtManager;
import com.api.globalState.utils.exceptions.ResponseException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyService implements IPropertyService {
    private final PropertyRepository propertyRepository;
    private final FilesService filesService;
    private final JwtManager jwtManager;

    public PropertyService(PropertyRepository propertyRepository, FilesService filesService, JwtManager jwtManager) {
        this.propertyRepository = propertyRepository;
        this.filesService = filesService;
        this.jwtManager = jwtManager;
    }

    @Override
    public PropertyResponseDto getById(Integer idProperty) throws ResponseException {
        PropertyEntity entity = this.getProperty(idProperty);
        List<String> files = entity.getFiles().stream().map(file -> filesService.getFileAsBase64(file.getPath())).toList();

        return new PropertyResponseDto(entity, files);
    }

    @Override
    public PropertyEntity updateProperty(PropertyEntity entity, Integer idProperty) throws ResponseException {
        this.getProperty(idProperty);
        entity.setIdProperty(idProperty);
        return propertyRepository.save(entity);
    }

    @Override
    public PropertyEntity deleteProperty(Integer idProperty) throws ResponseException {
        PropertyEntity entity = this.getProperty(idProperty);
        entity.setActive(false);
        return propertyRepository.save(entity);
    }

    @Override
    public List<PropertyResponseDto> getAll(HashMap<String, String> params) {
        List<PropertyEntity> list;
        Specification<PropertyEntity> spec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), true);
        if (params.containsKey("search") && params.get("search") != null && !params.get("search").isEmpty()) {
            String search = params.get("search");
            Specification<PropertyEntity> likeName = (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + search + "%");
            Specification<PropertyEntity> likeDetails = (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("details"), "%" + search + "%");
            Specification<PropertyEntity> searchSpec = likeName.or(likeDetails);
            spec = spec.and(searchSpec);
        }
        if (params.containsKey("state") && params.get("state") != null && !params.get("state").isEmpty()) {
            String search = params.get("state");
            Specification<PropertyEntity> state = (root, query, criteriaBuilder) -> {
                Join<PropertyEntity, PropertyStateEntity> stateJoin = root.join("stateProperty", JoinType.INNER);
                return criteriaBuilder.like(stateJoin.get("name"), "%" + search + "%");
            };
            spec = spec.and(state);
        }
        if (params.containsKey("type") && params.get("type") != null && !params.get("type").isEmpty()) {
            String search = params.get("type");
            Specification<PropertyEntity> state = (root, query, criteriaBuilder) -> {
                Join<PropertyStateEntity, PropertyStateEntity> stateJoin = root.join("type", JoinType.INNER);
                return criteriaBuilder.like(stateJoin.get("name"), "%" + search + "%");
            };
            spec = spec.and(state);
        }


        list = propertyRepository.findAll(spec);
        return list.stream().map(element -> {
            List<String> files = new ArrayList<>();
            try {
                for(FileEntity file: element.getFiles()){
                    if(file.isActive())
                        files.add(filesService.getFileAsBase64(file.getPath()));
                }
            }catch (RuntimeException ignored){}
            return new PropertyResponseDto(element, files );
        }).toList();
    }

    @Override
    public PropertyEntity createProperty(PropertyDto body, String token) {
        Integer idUser = jwtManager.getIdFromToken(token);
        List<FileEntity> files = filesService.saveFiles(body.getFiles());
        PropertyEntity entity = body.toEntity();
        UserEntity user = new UserEntity();
        user.setIdUser(idUser);
        entity.setFiles(files);
        entity.setCreator(user);
        return propertyRepository.save(entity);
    }

    private PropertyEntity getProperty(Integer idProperty) throws ResponseException {
     return propertyRepository.findById(idProperty).orElseThrow(()-> new ResponseException("Property not found"));
    }
}
