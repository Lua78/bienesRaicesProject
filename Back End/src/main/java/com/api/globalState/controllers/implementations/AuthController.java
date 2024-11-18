package com.api.globalState.controllers.implementations;

import com.api.globalState.controllers.interfaces.IAuthController;
import com.api.globalState.dtos.request.LoginDto;
import com.api.globalState.dtos.request.RegisterWithLoginDto;
import com.api.globalState.dtos.response.LoginResponseDto;
import com.api.globalState.services.implementations.AuthService;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthController implements IAuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<GenericResponse<LoginResponseDto>> registerWithLogin(@Validated RegisterWithLoginDto body) throws ResponseException {
        return ResponseEntity.ok().body(new GenericResponse<>(authService.registerUserLogin(body),"OK", HttpStatus.OK));
    }

    @Override
    public ResponseEntity<GenericResponse<LoginResponseDto>> login(LoginDto body) {
        return null;
    }
}
