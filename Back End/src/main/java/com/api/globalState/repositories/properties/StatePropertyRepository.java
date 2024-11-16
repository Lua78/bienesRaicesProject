package com.api.globalState.repositories.properties;

import com.api.globalState.entities.properties.StatePropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatePropertyRepository extends JpaRepository<StatePropertyEntity, Integer>, JpaSpecificationExecutor<StatePropertyEntity> {
}
