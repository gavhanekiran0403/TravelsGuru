package com.travelsguru.app.model;

import java.time.LocalDateTime;

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
@Document(collection = "payments")
public class Payment {

	@Id
	private String PaymentId;
    private double amount;
    private String method;
    private String status;
    private LocalDateTime paymentDate;
    
    private String bookingIds;
}
