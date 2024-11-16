package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer>, JpaSpecificationExecutor<PropertyEntity> {
}
