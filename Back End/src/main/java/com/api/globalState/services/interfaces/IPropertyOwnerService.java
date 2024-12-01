package com.api.globalState.services.interfaces;

import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.utils.exceptions.ResponseException;

import java.util.List;

public interface IPropertyOwnerService {
    PropertyOwnerEntity getById(Integer idProperty) throws ResponseException;
    PropertyOwnerEntity updateOwner(PropertyOwnerEntity entity, Integer idProperty) throws ResponseException;
    PropertyOwnerEntity deleteOwner(Integer idProperty) throws ResponseException;
    List<PropertyOwnerEntity> getAll();
    PropertyOwnerEntity createOwner(PropertyOwnerEntity entity);
}
