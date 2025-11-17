package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotels")
public class Hotel {

	@Id
	private String hotelId;
    private String hotelName;
    private double rating;
    private double pricePerNight;
    private String image;
    private Destination destination;
}
