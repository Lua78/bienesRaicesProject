package com.api.globalState.dtos.request;

import com.api.globalState.entities.auth.LoginEntity;
import com.api.globalState.entities.auth.RolEntity;
import com.api.globalState.utils.Jwt.Hash;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private Long idRol;

    public LoginEntity toEntity(){
        LoginEntity entity = new LoginEntity();
        entity.setPassword(Hash.sha3256(this.getPassword()));
        entity.setUsername(this.getUsername());
        if(idRol != null){
            RolEntity rol = new RolEntity();
            rol.setIdRol(this.idRol);
            entity.setRol(rol);
        }
        return entity;
    }
}
