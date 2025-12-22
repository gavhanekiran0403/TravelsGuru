package com.travelsguru.app.service;

import java.util.List;
import com.travelsguru.app.dto.UserDto;

public interface UserService {

    UserDto addUser(UserDto userDto);

    UserDto updateUser(String userId, UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(String userId);

    String deleteUser(String userId);
}
