package com.travelsguru.app.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Reviews")
public class Review {

	@Id
	private String ReviewId;
	private User user;
	private TravelPackage travelPackage;
	private int rating;
	private String comment;
	private LocalDateTime createdAt;
}
