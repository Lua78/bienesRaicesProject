package com.api.globalState.services.implementations;

import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.repositories.properties.PropertyRepository;
import com.api.globalState.services.interfaces.IPropertyService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService implements IPropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyEntity getById(Integer idProperty) throws ResponseException {
        return this.getProperty(idProperty);
    }

    @Override
    public PropertyEntity updateProperty(PropertyEntity entity, Integer idProperty) throws ResponseException {
        this.getProperty(idProperty);
        entity.setIdProperty(idProperty);
        return propertyRepository.save(entity);
    }

    @Override
    public PropertyEntity deleteProperty(Integer idProperty) throws ResponseException {
        PropertyEntity entity = this.getProperty(idProperty);
        entity.setActive(false);
        return propertyRepository.save(entity);
    }

    @Override
    public List<PropertyEntity> getAll() {
        return propertyRepository.findAllByActiveTrue();
    }

    @Override
    public PropertyEntity createProperty(PropertyEntity entity) {
        return  propertyRepository.save(entity);
    }

    private PropertyEntity getProperty(Integer idProperty) throws ResponseException {
     return propertyRepository.findById(idProperty).orElseThrow(()-> new ResponseException("Property not found"));
    }
}
