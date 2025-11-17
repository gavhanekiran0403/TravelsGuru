package com.travelsguru.app.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Booking {

	@Id
    private String BookingId;
    private TravelPackage travelPackage;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;
    private String status;
    private User user;
    private Hotel hotel;
}
