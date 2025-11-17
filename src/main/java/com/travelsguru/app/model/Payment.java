package com.travelsguru.app.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {

	@Id
	private String PaymentId;
    private Booking booking;
    private double amount;
    private String method;
    private String status;
    private LocalDateTime paymentDate;
}
