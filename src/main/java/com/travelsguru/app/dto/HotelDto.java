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
public class HotelDto {

	private String hotelId;
    private String hotelName;
    private double rating;
    private double pricePerNight;
    private String image;
    
    private String destinationId;
}
