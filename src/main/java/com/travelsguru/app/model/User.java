package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private String UserId;
    private String userName;
    private String email;
    private String mobileNo;
    private String password;
    private String confirmPassword;
    private String activeStatus;
}
