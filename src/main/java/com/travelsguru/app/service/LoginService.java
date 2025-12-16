package com.travelsguru.app.service;

import com.travelsguru.app.dto.LoginResponse;
import com.travelsguru.app.model.Login;

public interface LoginService {

    LoginResponse login(Login login);
}
