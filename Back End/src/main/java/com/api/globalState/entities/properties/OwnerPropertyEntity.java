package com.api.globalState.entities.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Data
@Entity
public class OwnerPropertyEntity {
    @Id
    private Long idOwnerProperty;

    private String name;

    private String lastName;

    private String email;

    private String identityCard;

    @OneToMany
    @JsonIgnore
    List<PropertyEntity> properties;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;
}