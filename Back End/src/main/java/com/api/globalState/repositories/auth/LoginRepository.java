package com.api.globalState.repositories.auth;

import com.api.globalState.entities.auth.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LoginRepository extends JpaRepository<LoginEntity, Integer>, JpaSpecificationExecutor<LoginEntity> {

    boolean existsByUsername(String username);
}
