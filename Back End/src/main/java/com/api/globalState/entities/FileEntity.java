package com.api.globalState.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Calendar;

@Entity
@Data
public class FileEntity {
    @Id
    private Long idFile;

    private String fileName;

    private String path;

    @ManyToOne
    private TypeFileEntity typeFile;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;
}
