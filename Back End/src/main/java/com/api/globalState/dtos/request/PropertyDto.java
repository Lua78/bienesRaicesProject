package com.api.globalState.dtos.request;

import com.api.globalState.entities.auth.UserEntity;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.entities.properties.PropertyStateEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
public class PropertyDto {
    private Integer idProperty;
    private String name;
    private String details;
    private String address;
    private BigDecimal price;
    private List<String> files; // Referencia a un DTO para archivos
    private Integer ownerId; // ID del propietario
    private Integer creatorId; // ID del creador
    private Integer statePropertyId; // ID del estado de la propiedad
    private Long rooms;
    private Long bathRooms;
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

    public PropertyEntity toEntity() {
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setIdProperty(this.idProperty);
        propertyEntity.setName(this.name);
        propertyEntity.setDetails(this.details);
        propertyEntity.setAddress(this.address);
        propertyEntity.setPrice(this.price);


        if (this.ownerId != null) {
            PropertyOwnerEntity owner = new PropertyOwnerEntity();
            owner.setIdPropertyOwner(ownerId);
            propertyEntity.setOwner(owner);
        }

        if (this.creatorId != null) {
            UserEntity creator = new UserEntity();
            creator.setIdUser(creatorId);
            propertyEntity.setCreator(creator);
        }

        if (this.statePropertyId != null) {
            PropertyStateEntity stateProperty = new PropertyStateEntity();
            stateProperty.setIdPropertyState(statePropertyId);
            propertyEntity.setStateProperty(stateProperty);
        }

        propertyEntity.setRooms(this.rooms);
        propertyEntity.setBathRooms(this.bathRooms);
        propertyEntity.setTotalArea(this.totalArea);
        propertyEntity.setYearsConstruction(this.yearsConstruction);
        propertyEntity.setGarden(this.garden);
        propertyEntity.setYard(this.yard);
        propertyEntity.setLivingRoom(this.livingRoom);
        propertyEntity.setKitchen(this.kitchen);
        propertyEntity.setDinningRoom(this.dinningRoom);
        propertyEntity.setServiceRoom(this.serviceRoom);
        propertyEntity.setLaundryRoom(this.laundryRoom);
        propertyEntity.setPrivateSecurity(this.privateSecurity);
        propertyEntity.setPool(this.pool);
        propertyEntity.setStudio(this.studio);
        propertyEntity.setGarage(this.garage);
        propertyEntity.setTerrace(this.terrace);
        propertyEntity.setVoltage220(this.voltage220);
        propertyEntity.setSchools(this.schools);
        propertyEntity.setNearbyTraffic(this.nearbyTraffic);
        propertyEntity.setConstructionArea(this.constructionArea);

        return propertyEntity;
    }
}
