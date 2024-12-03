package com.api.globalState.dtos.response;

import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.entities.properties.PropertyTypeEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PropertyResponseDto {
    private Integer idProperty;
    private String name;
    private String details;
    private String address;
    private BigDecimal price;
    private List<String> files; // Referencia a un DTO para archivos
    private PropertyOwnerEntity owner; // ID del propietario// ID del creador
    private PropertyStateEntity state;// ID del estado de la propiedad
    private PropertyTypeEntity type;
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

    public PropertyResponseDto(PropertyEntity entity, List<String> files) {
        this.idProperty = entity.getIdProperty();
        this.name = entity.getName();
        this.details = entity.getDetails();
        this.address = entity.getAddress();
        this.price = entity.getPrice();
        this.files = files; // List<String> de archivos, que ya se pasa al constructor
        this.owner = entity.getOwner(); // Aquí puedes optar por mapear el propietario a un DTO si es necesario
        this.state = entity.getStateProperty(); // Aquí también puedes mapear el estado si es necesario
        this.type = entity.getType(); // Mapear el tipo de propiedad si es necesario
        this.rooms = entity.getRooms();
        this.bathRooms = entity.getBathRooms();
        this.totalArea = entity.getTotalArea();
        this.yearsConstruction = entity.getYearsConstruction();
        this.garden = entity.isGarden();
        this.yard = entity.isYard();
        this.livingRoom = entity.isLivingRoom();
        this.kitchen = entity.isKitchen();
        this.dinningRoom = entity.isDinningRoom();
        this.serviceRoom = entity.isServiceRoom();
        this.laundryRoom = entity.isLaundryRoom();
        this.privateSecurity = entity.isPrivateSecurity();
        this.pool = entity.isPool();
        this.studio = entity.isStudio();
        this.garage = entity.isGarage();
        this.terrace = entity.isTerrace();
        this.voltage220 = entity.isVoltage220();
        this.schools = entity.isSchools();
        this.nearbyTraffic = entity.isNearbyTraffic();
        this.constructionArea = entity.isConstructionArea();
    }

}
