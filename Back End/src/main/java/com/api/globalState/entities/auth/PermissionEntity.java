package com.api.globalState.entities.auth;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Data
@Entity
public class PermissionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idPermission;

    private String name;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
