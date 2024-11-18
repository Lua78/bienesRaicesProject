package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.LoginDto;
import com.api.globalState.dtos.request.RegisterWithLoginDto;
import com.api.globalState.dtos.response.LoginResponseDto;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
public interface IAuthController {

    @PostMapping("/register")
    ResponseEntity<GenericResponse<LoginResponseDto>> registerWithLogin(@Valid @RequestBody RegisterWithLoginDto body) throws ResponseException;


    @PostMapping("/login")
    ResponseEntity<GenericResponse<LoginResponseDto>> login(@RequestBody LoginDto body);

}
