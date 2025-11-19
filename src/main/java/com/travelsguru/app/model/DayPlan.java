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
@Document(collection = "day_plans")
public class DayPlan {

	@Id
	private String DayPlanId;
    private int dayNumber;
    private String description;
    
    @DBRef
    private TravelPackage travelPackage;
    
    @DBRef
    private Activity activity;
}
