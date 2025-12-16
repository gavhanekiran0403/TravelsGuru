package com.travelsguru.app.dto;

import com.travelsguru.app.model.Hotel;

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
public class RoomDto {

	private String roomId;
	private String roomNo;
	private String roomType;
	private double pricePerNight;
    private boolean available;
    private String image;
    
    private Hotel hotel;
}
