package com.verde.realestates.service;


import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.dto.response.RegisterUserResDto;
import com.verde.realestates.model.User;


public interface AuthenticationService {
    RegisterUserResDto registerUser(UserRegistrationReqDto userRegistrationReqDto);
    User authenticateUser(UserLoginReqDto userLoginReqDto);
}
