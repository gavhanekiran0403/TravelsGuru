package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.UserDto;
import com.travelsguru.app.model.User;
import com.travelsguru.app.repositories.UserRepository;
import com.travelsguru.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ================= ENTITY → DTO =================
    private UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());   // ✅ CHANGED
        dto.setEmail(user.getEmail());
        dto.setMobileNo(user.getMobileNo());
        dto.setActiveStatus(user.getActiveStatus());
        return dto;
    }

    // ================= DTO → ENTITY =================
    private User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUserId(dto.getUserId());
        user.setFullName(dto.getFullName());   // ✅ CHANGED
        user.setEmail(dto.getEmail());
        user.setMobileNo(dto.getMobileNo());
        user.setPassword(dto.getPassword());
        user.setConfirmPassword(dto.getConfirmPassword());
        user.setActiveStatus(dto.getActiveStatus());
        return user;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User saved = userRepository.save(toEntity(userDto));
        return toDto(saved);
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User existing = userRepository.findById(userId).orElse(null);
        if (existing == null) return null;

        existing.setFullName(userDto.getFullName()); // ✅ CHANGED
        existing.setEmail(userDto.getEmail());
        existing.setMobileNo(userDto.getMobileNo());
        existing.setActiveStatus(userDto.getActiveStatus());
        existing.setPassword(userDto.getPassword());
        existing.setConfirmPassword(userDto.getConfirmPassword());

        return toDto(userRepository.save(existing));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(String userId) {
        return userRepository.findById(userId)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public String deleteUser(String userId) {
        userRepository.deleteById(userId);
        return "User deleted successfully!";
    }
}
