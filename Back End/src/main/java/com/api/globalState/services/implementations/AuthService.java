package com.api.globalState.services.implementations;

import com.api.globalState.dtos.request.LoginDto;
import com.api.globalState.dtos.request.RegisterWithLoginDto;
import com.api.globalState.dtos.response.LoginResponseDto;
import com.api.globalState.entities.auth.LoginEntity;
import com.api.globalState.entities.auth.UserEntity;
import com.api.globalState.repositories.auth.LoginRepository;
import com.api.globalState.repositories.auth.UserRepository;
import com.api.globalState.services.interfaces.IAuthService;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {


    private final LoginRepository loginRepository;
    private final UserRepository userRepository;

    public AuthService(LoginRepository loginRepository, UserRepository userRepository) {
        this.loginRepository = loginRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoginResponseDto registerUserLogin(RegisterWithLoginDto data) throws ResponseException {
       boolean existUsername = loginRepository.existsByUsername(data.getLogin().getUsername());
       if (existUsername)
           throw  new ResponseException("Username already in use");
       boolean existEmail = userRepository.existsByEmail(data.getUser().getEmail());
        if (existEmail)
            throw  new ResponseException("Email already in use");
        UserEntity user = userRepository.save(data.getUser().toEntity());
        LoginEntity login = data.getLogin().toEntity();
        login.setUser(user);
        login = loginRepository.save(login);
        return new LoginResponseDto(login, user);
    }
}
