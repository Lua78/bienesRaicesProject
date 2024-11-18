package com.api.globalState.dtos.request;

import lombok.Data;

@Data
public class RegisterWithLoginDto {


    private RegisterUerDto user;

    private LoginDto login;
}
