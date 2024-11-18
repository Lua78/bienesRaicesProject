package com.api.globalState.dtos.response;

import com.api.globalState.entities.auth.LoginEntity;
import com.api.globalState.entities.auth.UserEntity;
import lombok.Data;

@Data
public class LoginResponseDto {
    private Long idLogin;
    
    private UserResponseDto user;

    private String username;

    public LoginResponseDto(LoginEntity login, UserEntity user){
        this.user = new UserResponseDto(user);
        this.idLogin = login.getIdLogin();
        this.username = login.getUsername();
    }
}
