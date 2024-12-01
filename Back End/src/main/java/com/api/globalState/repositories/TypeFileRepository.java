package com.api.globalState.repositories;

import com.api.globalState.entities.FileTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeFileRepository extends JpaRepository<FileTypeEntity, Integer>, JpaSpecificationExecutor<FileTypeEntity> {
}
