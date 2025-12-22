package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.BookingDto;
import com.travelsguru.app.enums.BookingType;

public interface BookingService {

    BookingDto createBooking(BookingDto bookingDto);

    BookingDto updateBooking(String bookingId, BookingDto bookingDto);

    BookingDto getBookingById(String bookingId);

    List<BookingDto> getAllBookings();

    List<BookingDto> getBookingsByUser(String userId);

    List<BookingDto> getBookingsByDestination(String destinationId);

    List<BookingDto> getBookingsByType(BookingType bookingType);

    List<BookingDto> getBookingsByStatus(String status);

    void cancelBooking(String bookingId);
}
