package com.verde.realestates.service;


import com.verde.realestates.dto.request.UserLoginReqDto;
import com.verde.realestates.dto.request.UserRegistrationReqDto;
import com.verde.realestates.model.User;


public interface AuthenticationService {
    User registerUser(UserRegistrationReqDto userRegistrationReqDto);
    User authenticateUser(UserLoginReqDto userLoginReqDto);
}
