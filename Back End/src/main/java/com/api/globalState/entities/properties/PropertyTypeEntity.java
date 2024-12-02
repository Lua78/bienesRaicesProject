package com.api.globalState.entities.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
@Table(name = "property_type")
public class PropertyTypeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPropertyType;

    private String name;

    private String description;

    @OneToMany
    @JsonIgnore
    List<PropertyEntity> properties;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;



}
