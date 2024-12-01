package com.api.globalState.entities.properties;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;

@Entity
@Data
@Table(name = "property_category")
public class PropertyCategoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idPropertyCategory;

    private String name;

    private String description;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
