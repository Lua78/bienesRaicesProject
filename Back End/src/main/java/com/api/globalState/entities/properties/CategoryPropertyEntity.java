package com.api.globalState.entities.properties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;

@Entity
@Data
public class CategoryPropertyEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idCategoryProperty;

    private String name;

    private String description;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
