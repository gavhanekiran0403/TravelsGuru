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
@Document(collection = "travel_packages")
public class TravelPackage {

	@Id
	private String packageId;
    private String packageTitle;
    private double price;
    private int days;
    private int nights;
    private String description;
    
    @DBRef
    private Destination destination;
    
    @DBRef
    private List<Hotel> hotels;
    
    @DBRef
    private List<Activity> activities;
    
    @DBRef
    private List<DayPlan> dayPlans;
}
