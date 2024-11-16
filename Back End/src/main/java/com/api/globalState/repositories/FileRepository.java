package com.api.globalState.repositories;

import com.api.globalState.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FileRepository extends JpaRepository<FileEntity, Integer>, JpaSpecificationExecutor<FileEntity> {
}
