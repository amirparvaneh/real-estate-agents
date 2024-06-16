package com.verde.realestates.controller;


import com.verde.realestates.auth.JwtService;
import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.dto.response.BaseResponse;
import com.verde.realestates.dto.response.UserLoginResDto;
import com.verde.realestates.dto.response.RegisterUserResDto;
import com.verde.realestates.model.User;
import com.verde.realestates.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<RegisterUserResDto>> registerUser(@RequestBody @Valid UserRegistrationReqDto registerUserDto) {
        RegisterUserResDto registerUserResDto = authenticationService.registerUser(registerUserDto);
        BaseResponse<RegisterUserResDto> response = BaseResponse.<RegisterUserResDto>builder()
                .message("successfully registered")
                .result(registerUserResDto).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResDto> authenticateUser(@RequestBody UserLoginReqDto userLoginReqDto) {
        User authenticatedUser = authenticationService.authenticateUser(userLoginReqDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        UserLoginResDto loginResponse = UserLoginResDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
        return ResponseEntity.ok(loginResponse);
    }
}
