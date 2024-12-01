package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.PropertyOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PropertyOwnerRepository extends JpaRepository<PropertyOwnerEntity, Integer>, JpaSpecificationExecutor<PropertyOwnerEntity> {

    List<PropertyOwnerEntity> findAllByActiveTrue();
}
