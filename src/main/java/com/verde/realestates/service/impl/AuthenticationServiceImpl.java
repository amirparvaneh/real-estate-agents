package com.verde.realestates.service.impl;

import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.exceptions.UserException;
import com.verde.realestates.model.User;
import com.verde.realestates.repository.UserRepository;
import com.verde.realestates.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User registerUser(UserRegistrationReqDto userRegistrationReqDto) {
        User user = User.builder()
                .firstName(userRegistrationReqDto.getFirstName())
                .lastName(userRegistrationReqDto.getLastName())
                .email(userRegistrationReqDto.getEmail())
                .password(passwordEncoder.encode(userRegistrationReqDto.getPassword()))
                .userName(userRegistrationReqDto.getUserName())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(UserLoginReqDto userLoginReqDto) {
        User user = userRepository.findUserByUserName(userLoginReqDto.getUserName())
                .orElseThrow(() -> new UserException("User not found for username: " + userLoginReqDto.getUserName()
                        , userLoginReqDto.getUserName()));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginReqDto.getUserName(),
                userLoginReqDto.getPassword()
        ));
        return user;
    }
}
