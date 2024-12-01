package com.api.globalState.controllers.implementations;

import com.api.globalState.controllers.interfaces.IPropertyController;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.services.implementations.PropertyService;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.Jwt.JwtManager;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController implements IPropertyController {

    private final PropertyService propertyService;
    private final JwtManager jwtManager;

    public PropertyController(PropertyService propertyService, JwtManager jwtManager) {
        this.propertyService = propertyService;
        this.jwtManager = jwtManager;
    }

    @Override
    public ResponseEntity<GenericResponse<List<PropertyEntity>>> getAllProperties(SearchParamsDto params) {
        return ResponseEntity.ok().body(new GenericResponse<>("success", propertyService.getAll()));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> getProperty(Integer idProperty) throws ResponseException {
        return ResponseEntity.ok().body(new GenericResponse<>("success", propertyService.getById(idProperty)));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> updateProperty(Integer idProperty, PropertyEntity property, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", propertyService.updateProperty(property, idProperty)));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> createProperty(PropertyEntity property, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", propertyService.createProperty(property)));
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> deleteProperty(Integer idProperty, String token) throws ResponseException {
        if(!jwtManager.isThisRole(token, "admin"))
            throw new ResponseException("dont have permission for this path");
        return ResponseEntity.ok().body(new GenericResponse<>("success", propertyService.deleteProperty(idProperty)));
    }
}
