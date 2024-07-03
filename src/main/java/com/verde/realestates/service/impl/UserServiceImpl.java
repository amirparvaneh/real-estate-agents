package com.verde.realestates.service.impl;

import com.verde.realestates.model.User;
import com.verde.realestates.repository.UserRepository;
import com.verde.realestates.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }
}
