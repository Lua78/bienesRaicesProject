package com.api.globalState.services.implementations;

import com.api.globalState.entities.properties.PropertyTypeEntity;
import com.api.globalState.repositories.properties.PropertyStateRepository;
import com.api.globalState.repositories.properties.PropertyTypeRepository;
import com.api.globalState.services.interfaces.IPropertyStateService;
import com.api.globalState.services.interfaces.IPropertyTypeService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyTypeService implements IPropertyTypeService {
    private final PropertyTypeRepository propertyRepository;

    public PropertyTypeService(PropertyTypeRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyTypeEntity getById(Integer idProperty) throws ResponseException {
        return this.getProperty(idProperty);
    }

    @Override
    public PropertyTypeEntity updateProperty(PropertyTypeEntity entity, Integer id) throws ResponseException {
        this.getProperty(id);
        entity.setIdPropertyType(id);
        return propertyRepository.save(entity);
    }

    @Override
    public PropertyTypeEntity deleteProperty(Integer id) throws ResponseException {
        PropertyTypeEntity entity = this.getProperty(id);
        entity.setActive(false);
        return propertyRepository.save(entity);
    }

    @Override
    public List<PropertyTypeEntity> getAll() {
        return propertyRepository.findAllByActiveTrue();
    }

    @Override
    public PropertyTypeEntity createProperty(PropertyTypeEntity entity) {
        return  propertyRepository.save(entity);
    }

    private PropertyTypeEntity getProperty(Integer idProperty) throws ResponseException {
     return propertyRepository.findById(idProperty).orElseThrow(()-> new ResponseException("Property type not found"));
    }
}
