package com.api.globalState.repositories.auth;

import com.api.globalState.entities.auth.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolRepository extends JpaRepository<RolEntity, Integer>, JpaSpecificationExecutor<RolEntity> {
}
