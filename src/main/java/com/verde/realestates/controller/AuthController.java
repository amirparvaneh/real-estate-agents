package com.verde.realestates.controller;


import com.verde.realestates.auth.JwtService;
import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.dto.response.LoginResDto;
import com.verde.realestates.model.User;
import com.verde.realestates.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationReqDto registerUserDto) {
        User registeredUser = authenticationService.registerUser(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResDto> authenticateUser(@RequestBody UserLoginReqDto userLoginReqDto) {
        User authenticatedUser = authenticationService.authenticateUser(userLoginReqDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResDto loginResponse = LoginResDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return ResponseEntity.ok(loginResponse);
    }
}
