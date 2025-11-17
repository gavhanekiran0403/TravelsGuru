package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "day_plans")
public class DayPlan {

	@Id
	private String DayPlanId;
    private int dayNumber;
    private String description;
    private TravelPackage travelPackage;
    private Activity activity;
}
