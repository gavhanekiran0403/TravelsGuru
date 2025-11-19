package com.travelsguru.app.model;

import java.util.List;

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
@Document(collection = "destinations")
public class Destination {

	@Id
	private String destinationId;
	private String destinationName;
	private String country;
	private String image;
	private String description;
	
	@DBRef
	private DestinationCategory destinationCategory;
	
	@DBRef
	private List<TravelPackage> travelPackages;
	
	@DBRef
	private List<Hotel> hotels;
	
	@DBRef
	private List<Restaurant> restaurants;
	
	@DBRef
	private List<Activity> activities;
}
