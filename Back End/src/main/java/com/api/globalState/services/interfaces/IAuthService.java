package com.api.globalState.services.interfaces;

import com.api.globalState.dtos.request.LoginDto;
import com.api.globalState.dtos.request.RegisterWithLoginDto;
import com.api.globalState.dtos.response.LoginResponseDto;
import com.api.globalState.utils.exceptions.ResponseException;

public interface IAuthService {

    LoginResponseDto registerUserLogin(RegisterWithLoginDto data) throws ResponseException;
}
