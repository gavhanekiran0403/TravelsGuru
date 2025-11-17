package com.travelsguru.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
public class Activity {

	private String activityId;
    private String activityTitle;
    private double price;
    private String image;
    private Destination destination;
}
