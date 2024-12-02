package com.api.globalState.services.implementations;

import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.repositories.properties.PropertyOwnerRepository;
import com.api.globalState.services.interfaces.IPropertyOwnerService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyOwnerService implements IPropertyOwnerService {
    private final PropertyOwnerRepository repository;

    public PropertyOwnerService(PropertyOwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PropertyOwnerEntity getById(Integer id) throws ResponseException {
        return this.getEntity(id);
    }

    @Override
    public PropertyOwnerEntity update(PropertyOwnerEntity entity, Integer id) throws ResponseException {
        this.getEntity(id);
        entity.setIdPropertyOwner(id);
        return repository.save(entity);
    }

    @Override
    public PropertyOwnerEntity delete(Integer id) throws ResponseException {
        PropertyOwnerEntity propertyOwnerEntity = this.getEntity(id);
        propertyOwnerEntity.setActive(false);
        return repository.save(propertyOwnerEntity);
    }

    @Override
    public List<PropertyOwnerEntity> getAll() {
        return repository.findAllByActiveTrue();
    }

    @Override
    public PropertyOwnerEntity create(PropertyOwnerEntity entity) {
        return repository.save(entity);
    }

    private PropertyOwnerEntity getEntity(Integer idOwner) throws ResponseException {
        return repository.findById(idOwner).orElseThrow(() -> new ResponseException("Property owner not found"));
    }

}
