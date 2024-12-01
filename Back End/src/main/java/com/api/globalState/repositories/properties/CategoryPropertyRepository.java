package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryPropertyRepository extends JpaRepository<PropertyCategoryEntity, Integer>, JpaSpecificationExecutor<PropertyCategoryEntity> {
}
