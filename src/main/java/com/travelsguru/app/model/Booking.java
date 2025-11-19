package com.travelsguru.app.model;

import java.time.LocalDate;

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
@Document(collection = "bookings")
public class Booking {

	@Id
    private String BookingId;
	
	@DBRef
    private TravelPackage travelPackage;
	
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;
    private String status;
    
    @DBRef
    private User user;
    
    @DBRef
    private Hotel hotel;
}
