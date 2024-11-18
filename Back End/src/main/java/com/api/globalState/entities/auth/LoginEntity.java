package com.api.globalState.entities.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;

@Entity
@Data
public class LoginEntity {
    @Id
    private Long idLogin;

    private String username;

    @JsonIgnore
    private String password;

    @OneToOne
    private RolEntity rol;

    @OneToOne
    private UserEntity user;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
