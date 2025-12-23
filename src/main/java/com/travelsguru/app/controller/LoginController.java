package com.travelsguru.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.LoginResponse;
import com.travelsguru.app.model.Login;
import com.travelsguru.app.service.LoginService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // LOGIN
    @PostMapping("/login")
    public LoginResponse login(@RequestBody Login login) {
        return loginService.login(login);
    }

    // LOGOUT
    @PostMapping("/logout/{userId}")
    public String logout(@PathVariable String userId) {
        return loginService.logout(userId);
    }
}
