package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypePropertyRepository extends JpaRepository<PropertyTypeEntity, Integer>, JpaSpecificationExecutor<PropertyTypeEntity> {
}
