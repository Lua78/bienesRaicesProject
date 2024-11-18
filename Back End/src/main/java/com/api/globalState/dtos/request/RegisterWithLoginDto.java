package com.api.globalState.dtos.request;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class RegisterWithLoginDto {
    @Valid
    private RegisterUerDto user;

    @Valid
    private LoginDto login;
}
