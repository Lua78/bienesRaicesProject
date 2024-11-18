package com.api.globalState.entities.auth;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class RolEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idRol;

    private String name;

    @OneToMany
    private List<PermissionEntity> permissionEntities;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;
}
