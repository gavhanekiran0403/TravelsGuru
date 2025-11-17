package com.travelsguru.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "travel_packages")
public class TravelPackage {

	@Id
	private String packageId;
    private String packageTitle;
    private double price;
    private int days;
    private int nights;
    private String description;
    private Destination destination;
    private List<Hotel> hotels;
    private List<Activity> activities;
    private List<DayPlan> dayPlans;
}
