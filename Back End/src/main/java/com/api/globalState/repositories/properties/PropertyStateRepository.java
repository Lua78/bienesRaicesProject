package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PropertyStateRepository extends JpaRepository<PropertyStateEntity, Integer>, JpaSpecificationExecutor<PropertyStateEntity> {
    List<PropertyStateEntity> findAllByActiveTrue();
}
