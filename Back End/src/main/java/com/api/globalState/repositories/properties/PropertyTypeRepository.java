package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PropertyTypeRepository extends JpaRepository<PropertyTypeEntity, Integer>, JpaSpecificationExecutor<PropertyTypeEntity> {
    List<PropertyTypeEntity> findAllByActiveTrue();
}
