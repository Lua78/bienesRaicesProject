package com.api.globalState.controllers.implementations;


import com.api.globalState.controllers.interfaces.IPropertyOwnerController;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyOwnerController implements IPropertyOwnerController {
    @Override
    public ResponseEntity<GenericResponse<List<PropertyEntity>>> getAllOwners(SearchParamsDto params) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> getOwner(Integer idOwner) throws ResponseException {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> updateOwner(Integer idOwner, PropertyEntity property, String token) throws ResponseException {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> createOwner(PropertyEntity property, String token) throws ResponseException {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse<PropertyEntity>> deleteOwner(Integer idOwner, String token) throws ResponseException {
        return null;
    }
}
