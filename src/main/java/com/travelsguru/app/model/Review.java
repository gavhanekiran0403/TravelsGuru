package com.travelsguru.app.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection = "Reviews")
public class Review {

	@Id
	private String reviewId;
	private int rating;
	private String comment;
	private LocalDateTime createdAt;
	
	private String userId;
	
	private String travelPackageId;
}
