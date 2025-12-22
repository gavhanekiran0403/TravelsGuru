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
@Document(collection = "day_plans")
public class DayPlan {

	@Id
	private String dayPlanId;
    
    private String travelPackageId;
    private List<DayPlan.Day> days;

    
 // ================= INNER DAY CLASS =================
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Day {

        private int dayNumber;           // Day 1, Day 2
        private String description;      // Day-wise description
        private List<String> activityIds; // Activity IDs or names
    }
    
}