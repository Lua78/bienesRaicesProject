package com.api.globalState.services.implementations;

import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.repositories.properties.PropertyOwnerRepository;
import com.api.globalState.services.interfaces.IPropertyOwnerService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyOwnerService implements IPropertyOwnerService {
    private final PropertyOwnerRepository propertyOwnerRepository;

    public PropertyOwnerService(PropertyOwnerRepository propertyOwnerRepository) {
        this.propertyOwnerRepository = propertyOwnerRepository;
    }

    @Override
    public PropertyOwnerEntity getById(Integer idProperty) throws ResponseException {
        return null;
    }

    @Override
    public PropertyOwnerEntity updateOwner(PropertyOwnerEntity entity, Integer idProperty) throws ResponseException {
        return null;
    }

    @Override
    public PropertyOwnerEntity deleteOwner(Integer idProperty) throws ResponseException {
        return null;
    }
    @Override
    public List<PropertyOwnerEntity> getAll(){
        return propertyOwnerRepository.findAllByActiveTrue();
    }

    @Override
    public PropertyOwnerEntity createOwner(PropertyOwnerEntity entity) {
        return null;
    }

    private PropertyOwnerEntity getProperty(Integer idOwner) throws ResponseException {
        return propertyOwnerRepository.findById(idOwner).orElseThrow(()-> new ResponseException("Property owner not found"));
    }

}
