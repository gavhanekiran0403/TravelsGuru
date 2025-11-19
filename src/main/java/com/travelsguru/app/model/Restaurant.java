package com.travelsguru.app.model;

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
@Document(collection = "restaurants")
public class Restaurant {

	@Id
	private String restaurantId;
	private String restaurantName;
	private double rating;
	private String image;
	private double averageCost;

	@DBRef
	private Destination destination;
}
