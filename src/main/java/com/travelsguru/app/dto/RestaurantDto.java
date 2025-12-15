package com.travelsguru.app.dto;

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
public class RestaurantDto {

	private String restaurantId;
	private String restaurantName;
	private double rating;
	private String image;
	private double averageCost;
	
	private String destinationIds;

}
