package com.travelsguru.app.mapper;

import com.travelsguru.app.dto.UserDto;
import com.travelsguru.app.model.User;

public class UserMapper {

    // ============ ENTITY → DTO ============
    public static UserDto toDto(User user) {
        if (user == null) return null;

        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setMobileNo(user.getMobileNo());
        dto.setActiveStatus(user.getActiveStatus());
        dto.setRole(user.getRole());         

        return dto;
    }

    // ============ DTO → ENTITY ============
    public static User toEntity(UserDto dto) {
        if (dto == null) return null;

        User user = new User();
        user.setUserId(dto.getUserId());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setMobileNo(dto.getMobileNo());
        user.setPassword(dto.getPassword());        
        user.setConfirmPassword(dto.getConfirmPassword());
        user.setActiveStatus(dto.getActiveStatus());
        user.setRole(dto.getRole());               

        return user;
    }
}
