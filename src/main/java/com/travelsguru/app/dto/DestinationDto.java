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
public class DestinationDto {

	private String destinationId;
	private String destinationName;
	private String country;
	private String image;
	private String description;

	private String destiCategoryId;

}
