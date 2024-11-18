package com.api.globalState.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;
import java.util.List;

@Data
@Entity
public class TypeFileEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idTypeFile;

    private String name;

    private String description;

    @JsonIgnore
    @OneToMany
    private List<FileEntity> files;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;
}
