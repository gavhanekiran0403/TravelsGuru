package com.travelsguru.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private String userId;
    private String fullName;  
    private String email;
    private String mobileNo;
    private String password;
    private String confirmPassword;
    private String activeStatus;
    
    private String role; 
}