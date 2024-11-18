package com.api.globalState.entities.auth;


import com.api.globalState.entities.properties.PropertyEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idUser;

    private String name;

    private String lastName;

    private String email;

    @OneToMany
    private List<PropertyEntity> properties;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
