package com.verde.realestates.service.impl;

import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.model.User;
import com.verde.realestates.repository.UserRepository;
import com.verde.realestates.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User registerUser(UserRegistrationReqDto userRegistrationReqDto) {
        return null;
    }

    @Override
    public User authenticateUser(UserLoginReqDto userLoginReqDto) {
        return null;
    }
}
