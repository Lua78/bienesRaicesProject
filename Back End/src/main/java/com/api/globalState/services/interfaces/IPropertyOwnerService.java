package com.api.globalState.services.interfaces;

import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.utils.exceptions.ResponseException;

import java.util.List;

public interface IPropertyOwnerService {
    PropertyOwnerEntity getById(Integer id) throws ResponseException;
    PropertyOwnerEntity update(PropertyOwnerEntity entity, Integer id) throws ResponseException;
    PropertyOwnerEntity delete(Integer id) throws ResponseException;
    List<PropertyOwnerEntity> getAll();
    PropertyOwnerEntity create(PropertyOwnerEntity entity);
}
