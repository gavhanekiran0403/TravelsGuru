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
public class CityDto {

	private String cityId;
	private String cityName;
	private String description;
	private String image;
	
	private String destinationId;
}
