package com.api.globalState.services.interfaces;

import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyTypeEntity;
import com.api.globalState.utils.exceptions.ResponseException;

import java.util.List;

public interface IPropertyTypeService {
    PropertyTypeEntity getById(Integer idProperty) throws ResponseException;
    PropertyTypeEntity updateProperty(PropertyTypeEntity entity, Integer idProperty) throws ResponseException;
    PropertyTypeEntity deleteProperty(Integer idProperty) throws ResponseException;
    List<PropertyTypeEntity> getAll();
    PropertyTypeEntity createProperty(PropertyTypeEntity entity);
}
