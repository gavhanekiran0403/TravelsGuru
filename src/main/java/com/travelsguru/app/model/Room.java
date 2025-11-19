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
@Document(collection = "rooms")
public class Room {

	@Id
    private String roomId;
	private String roomNo;
    private String roomType;      
    private double pricePerNight;
    private boolean available;
    private String image;

    @DBRef
    private Hotel hotel;
}
