package com.api.globalState.services.implementations;

import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.repositories.properties.PropertyRepository;
import com.api.globalState.repositories.properties.PropertyStateRepository;
import com.api.globalState.services.interfaces.IPropertyService;
import com.api.globalState.services.interfaces.IPropertyStateService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyStateService implements IPropertyStateService {
    private final PropertyStateRepository propertyRepository;

    public PropertyStateService(PropertyStateRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyStateEntity getById(Integer idProperty) throws ResponseException {
        return this.getProperty(idProperty);
    }

    @Override
    public PropertyStateEntity updateProperty(PropertyStateEntity entity, Integer id) throws ResponseException {
        this.getProperty(id);
        entity.setIdPropertyState(id);
        return propertyRepository.save(entity);
    }

    @Override
    public PropertyStateEntity deleteProperty(Integer id) throws ResponseException {
        PropertyStateEntity entity = this.getProperty(id);
        entity.setActive(false);
        return propertyRepository.save(entity);
    }

    @Override
    public List<PropertyStateEntity> getAll() {
        return propertyRepository.findAllByActiveTrue();
    }

    @Override
    public PropertyStateEntity createProperty(PropertyStateEntity entity) {
        return  propertyRepository.save(entity);
    }

    private PropertyStateEntity getProperty(Integer idProperty) throws ResponseException {
     return propertyRepository.findById(idProperty).orElseThrow(()-> new ResponseException("Property state not found"));
    }
}
