package com.verde.realestates.controller;


import com.verde.realestates.dto.response.BaseResponse;
import com.verde.realestates.model.User;
import com.verde.realestates.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.findAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
}
