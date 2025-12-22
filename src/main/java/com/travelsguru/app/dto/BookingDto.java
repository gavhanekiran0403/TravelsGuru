package com.travelsguru.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.travelsguru.app.enums.BookingType;

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
public class BookingDto {

    private String bookingId;
    private BookingType bookingType;
    private String travellerType;
    private String departureLocation;
    private String duration;
    private LocalDate startDate;

    private List<String> activityIds;
    private List<String> hotelIds;
    private String destinationId;
    private String travelPackageId;
    private String userId;

    private String totalAmount;
    private String status;
}
