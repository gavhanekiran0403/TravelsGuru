package com.travelsguru.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "destinations")
public class Destination {

	@Id
	private String destinationId;
	private String destinationName;
	private String country;
	private String image;
	private String description;
	private DestinationCategory destinationCategory;
	private List<TravelPackage> travelPackages;
	private List<Hotel> hotels;
	private List<Activity> activities;
}
