package com.api.globalState.controllers.implementations;

import com.api.globalState.controllers.interfaces.IPropertyController;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController implements IPropertyController {
    @Override
    public PropertyEntity getAllProperties(SearchParamsDto params) {
        return null;
    }

    @Override
    public PropertyEntity getProperty(String idProperty) {
        return null;
    }

    @Override
    public PropertyEntity updateProperty(String idProperty, PropertyEntity property) {
        return null;
    }

    @Override
    public PropertyEntity createProperty(String idProperty, PropertyEntity property) {
        return null;
    }

    @Override
    public PropertyEntity deleteProperty(String idProperty) {
        return null;
    }
}
