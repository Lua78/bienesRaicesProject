package com.api.globalState.repositories;

import com.api.globalState.entities.TypeFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeFileRepository extends JpaRepository<TypeFileEntity, Integer>, JpaSpecificationExecutor<TypeFileEntity> {
}
