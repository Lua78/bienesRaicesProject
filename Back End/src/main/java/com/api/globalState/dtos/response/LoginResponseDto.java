package com.api.globalState.dtos.response;

import com.api.globalState.entities.auth.LoginEntity;
import com.api.globalState.entities.auth.UserEntity;
import lombok.Data;

@Data
public class LoginResponseDto {
    private Integer idLogin;
    
    private UserResponseDto user;

    private String username;

    private String token;

    public LoginResponseDto(LoginEntity login, String token){
        this.user = new UserResponseDto(login.getUser());
        this.idLogin = login.getIdLogin();
        this.username = login.getUsername();
        this.token = token;
    }
}
