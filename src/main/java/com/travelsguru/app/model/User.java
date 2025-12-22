package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "users")
public class User {

	@Id
	private String userId;
    private String fullName;
    private String email;
    private String mobileNo;
    private String password;
    private String confirmPassword;
    private String activeStatus;
    
    private String role; 
}
 