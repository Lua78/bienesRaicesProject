package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.OwnerPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OwnerPropertyRepository extends JpaRepository<OwnerPropertyEntity, Integer>, JpaSpecificationExecutor<OwnerPropertyEntity> {
}
