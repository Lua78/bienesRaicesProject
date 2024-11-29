package com.api.globalState.entities.properties;


import com.api.globalState.entities.FileEntity;
import com.api.globalState.entities.auth.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
@Entity
public class PropertyEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idProperty;

    private String name;

    private String details;

    private String address;

    private BigDecimal price;

    @OneToMany
    private List<FileEntity> files;

    @ManyToOne
    private OwnerPropertyEntity owner;

    @ManyToOne
    private UserEntity creator;

    @ManyToOne
    private StatePropertyEntity stateProperty;

    private Long rooms;

    private Long bathRooms;

    //m^2
    private Long totalArea;

    private Long yearsConstruction;

    private boolean garden;

    private boolean yard;

    private boolean livingRoom;

    private boolean kitchen;

    private boolean dinningRoom;

    private boolean serviceRoom;

    private boolean laundryRoom;

    private boolean privateSecurity;

    private boolean pool;

    private boolean studio;

    private boolean garage;

    private boolean terrace;

    private boolean voltage220;

    private boolean schools;

    private boolean nearbyTraffic;

    private boolean constructionArea;

    @CreationTimestamp
    private Calendar dateCreation;

    @UpdateTimestamp
    private Calendar dateLastUpdate;

    private boolean active = true;

}
