package com.api.globalState.dtos.response;

import com.api.globalState.entities.auth.UserEntity;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long idUser;

    private String name;

    private String lastName;

    private String email;

    public UserResponseDto(UserEntity entity){
        this.idUser = entity.getIdUser();
        this.name = entity.getName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
    }
}
