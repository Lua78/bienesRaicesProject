package com.api.globalState.services.interfaces;

import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.utils.exceptions.ResponseException;

import java.util.List;

public interface IPropertyStateService {
    PropertyStateEntity getById(Integer idProperty) throws ResponseException;
    PropertyStateEntity updateProperty(PropertyStateEntity entity, Integer id) throws ResponseException;
    PropertyStateEntity deleteProperty(Integer id) throws ResponseException;
    List<PropertyStateEntity> getAll();
    PropertyStateEntity createProperty(PropertyStateEntity entity);
}
