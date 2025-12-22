package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.UserDto;
import com.travelsguru.app.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @PutMapping("/update/{userId}")
    public UserDto updateUser(@PathVariable String userId,
                              @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
