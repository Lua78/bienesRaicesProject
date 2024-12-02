package com.api.globalState.controllers.implementations;


import com.api.globalState.controllers.interfaces.IPropertyStateController;
import com.api.globalState.controllers.interfaces.IPropertyTypeController;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.services.implementations.PropertyStateService;
import com.api.globalState.services.implementations.PropertyTypeService;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.Jwt.JwtManager;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyStateController implements IPropertyStateController {
    private final PropertyStateService service;
    private final JwtManager jwtManager;

    public PropertyStateController(PropertyStateService service, JwtManager jwtManager) {
        this.service = service;
        this.jwtManager = jwtManager;
    }

    @Override
    public ResponseEntity<GenericResponse<List<PropertyStateEntity>>> getAll(SearchParamsDto params) {
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.getAll()));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyStateEntity>> getOne(Integer id) throws ResponseException {
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.getById(id) ));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyStateEntity>> update(Integer id, PropertyStateEntity entity, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.updateProperty(entity, id) ));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyStateEntity>> create(PropertyStateEntity entity, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.createProperty(entity)));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyStateEntity>> delete(Integer idOwner, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", service.deleteProperty(idOwner)));
    }
}
