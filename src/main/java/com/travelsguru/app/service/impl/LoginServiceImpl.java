package com.travelsguru.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.LoginResponse;
import com.travelsguru.app.model.Login;
import com.travelsguru.app.model.User;
import com.travelsguru.app.repositories.UserRepository;
import com.travelsguru.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(Login login) {

        User user = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(login.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (!"ACTIVE".equalsIgnoreCase(user.getActiveStatus())) {
            throw new RuntimeException("User is inactive");
        }

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        response.setFullName(user.getFullName());   
        response.setEmail(user.getEmail());
        response.setMobileNo(user.getMobileNo());
        response.setActiveStatus(user.getActiveStatus());
        response.setMessage("Login successful");

        return response;
    }
}
