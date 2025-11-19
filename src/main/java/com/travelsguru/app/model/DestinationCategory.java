package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "destination_categories")
public class DestinationCategory {

	@Id
	private String destiCategoryId;
	private String destiCategoryName;
	private String image;
	private String description;
	
}
