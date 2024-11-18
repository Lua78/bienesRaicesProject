package com.api.globalState.dtos.request;

import com.api.globalState.entities.auth.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUerDto {
    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setName(this.name);
        entity.setLastName(this.lastName);
        entity.setEmail(this.email);
        return  entity;
    }
}
