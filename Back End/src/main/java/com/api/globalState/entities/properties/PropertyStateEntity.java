package com.api.globalState.entities.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Data
@Entity
@Table(name = "property_state")
public class PropertyStateEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPropertyState;

    private String name;

    private String description;

    @OneToMany
    @JsonIgnore
    private List<PropertyEntity> properties;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;
}
