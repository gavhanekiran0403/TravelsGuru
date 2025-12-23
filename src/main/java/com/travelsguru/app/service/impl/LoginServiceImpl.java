package com.travelsguru.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.LoginResponse;
import com.travelsguru.app.model.Login;
import com.travelsguru.app.model.User;
import com.travelsguru.app.repository.UserRepository;
import com.travelsguru.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ ADD THIS

    // ================= LOGIN =================
    @Override
    public LoginResponse login(Login login) {

        User user = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // ✅ FIXED PASSWORD CHECK
        if (!passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // SET ACTIVE ON LOGIN
        user.setActiveStatus("ACTIVE");
        userRepository.save(user);

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUserId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setMobileNo(user.getMobileNo());
        response.setActiveStatus(user.getActiveStatus());
        response.setRole(user.getRole());
        response.setMessage("Login successful");

        return response;
    }

    // ================= LOGOUT =================
    @Override
    public String logout(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found with userId : " + userId));

        user.setActiveStatus("INACTIVE");
        userRepository.save(user);

        return "Logout successful";
    }
}
