package com.travelsguru.app.dto;

import java.util.List;

import com.travelsguru.app.model.DayPlan.Day;

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
public class DayPlanDto {

	private String dayPlanId;
    
    private String travelPackageId;
    private List<Day> days;
    
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Day {
    	
    	private int dayNumber;           
        private String description;      
        private List<String> activityIds;
    }
}
