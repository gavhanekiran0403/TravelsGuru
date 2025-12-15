package com.travelsguru.app.dto;

import java.util.List;

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
public class TravelPackageDto {

	private String packageId;
    private String packageTitle;
    private double price;
    private int days;
    private int nights;
    private String description;
    
    private String destinationId;
    
    private List<String> cityIds;
    
    private List<String> hotelIds;
    
    private List<String> activityIds;
    
    private List<String> dayPlanIds;
}
