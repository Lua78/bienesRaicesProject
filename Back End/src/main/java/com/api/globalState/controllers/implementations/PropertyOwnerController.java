package com.api.globalState.controllers.implementations;


import com.api.globalState.controllers.interfaces.IPropertyOwnerController;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.services.implementations.PropertyOwnerService;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.Jwt.JwtManager;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyOwnerController implements IPropertyOwnerController {
    private final PropertyOwnerService service;
    private final JwtManager jwtManager;

    public PropertyOwnerController(PropertyOwnerService service, JwtManager jwtManager) {
        this.service = service;
        this.jwtManager = jwtManager;
    }

    @Override
    public ResponseEntity<GenericResponse<List<PropertyOwnerEntity>>> getAllOwners(SearchParamsDto params) {
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.getAll()));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyOwnerEntity>> getOwner(Integer idOwner) throws ResponseException {
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.getById(idOwner) ));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyOwnerEntity>> updateOwner(Integer idOwner, PropertyOwnerEntity entity, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.update(entity, idOwner) ));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyOwnerEntity>> createOwner(PropertyOwnerEntity entity, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.create(entity)));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyOwnerEntity>> deleteOwner(Integer idOwner, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.delete(idOwner)));
    }
}
