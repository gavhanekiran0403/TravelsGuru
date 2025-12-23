package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
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
@Document(collection = "Hotels")
public class Hotel {

	@Id
	private String hotelId;
    private String hotelName;
    private double rating;
    private double pricePerNight;
    private String image;
    
    private String destinationId;
    
}
