package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.UserDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.UserMapper;
import com.travelsguru.app.model.User;
import com.travelsguru.app.repository.UserRepository;
import com.travelsguru.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ================= ADD USER =================
    @Override
    public UserDto addUser(UserDto userDto) {

        // Default role
        if (userDto.getRole() == null) {
            userDto.setRole("USER");
           
        }
        if (userDto.getActiveStatus() == null)  {
        	userDto.setActiveStatus("INACTIVE");
        }
        
        User savedUser = userRepository.save(UserMapper.toEntity(userDto));
        return UserMapper.toDto(savedUser);
    }

    // ================= UPDATE USER =================
    @Override
    public UserDto updateUser(String userId, UserDto userDto) {

        User existing = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "userId", userId));

        existing.setFullName(userDto.getFullName());
        existing.setEmail(userDto.getEmail());
        existing.setMobileNo(userDto.getMobileNo());
        existing.setActiveStatus(userDto.getActiveStatus());
        existing.setPassword(userDto.getPassword());
        existing.setConfirmPassword(userDto.getConfirmPassword());

        // update role only if provided
        if (userDto.getRole() != null) {
            existing.setRole(userDto.getRole());
        }

        return UserMapper.toDto(userRepository.save(existing));
    }

    // ================= GET ALL USERS =================
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    // ================= GET USER BY ID =================
    @Override
    public UserDto getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "userId", userId));

        return UserMapper.toDto(user);
    }

    // ================= DELETE USER =================
    @Override
    public String deleteUser(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "userId", userId));

        userRepository.delete(user);
        return "User deleted successfully!";
    }
}
 