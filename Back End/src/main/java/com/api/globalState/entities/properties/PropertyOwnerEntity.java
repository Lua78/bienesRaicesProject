package com.api.globalState.entities.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.net.Inet4Address;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "property_owner")
public class PropertyOwnerEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPropertyOwner;

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
