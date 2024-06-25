package com.verde.realestates.service;

import com.verde.realestates.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserByEmail(String email);
}
