package com.api.globalState.repositories.auth;

import com.api.globalState.entities.auth.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer>, JpaSpecificationExecutor<PermissionEntity> {
}
