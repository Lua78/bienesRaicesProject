package com.api.globalState.services.interfaces;

import com.api.globalState.dtos.request.PropertyDto;
import com.api.globalState.dtos.response.PropertyResponseDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.utils.exceptions.ResponseException;
import org.hibernate.mapping.Property;

import java.util.List;

public interface IPropertyService {
    PropertyResponseDto getById(Integer idProperty) throws ResponseException;
    PropertyEntity updateProperty(PropertyEntity entity, Integer idProperty) throws ResponseException;
    PropertyEntity deleteProperty(Integer idProperty) throws ResponseException;
    List<PropertyResponseDto> getAll();
    PropertyEntity createProperty(PropertyDto body, String token);
}
