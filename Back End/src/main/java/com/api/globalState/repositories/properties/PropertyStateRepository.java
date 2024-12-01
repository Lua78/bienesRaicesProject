package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropertyStateRepository extends JpaRepository<PropertyStateEntity, Integer>, JpaSpecificationExecutor<PropertyStateEntity> {
}
