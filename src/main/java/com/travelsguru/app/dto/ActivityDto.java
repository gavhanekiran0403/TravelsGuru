package com.travelsguru.app.dto;

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
public class ActivityDto {

	private String activityId;
    private String activityTitle;
    private double price;
    private String image;
    
    private String destinationId;
}
