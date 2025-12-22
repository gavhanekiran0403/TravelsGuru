package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

    // Find bookings by user
    List<Booking> findByUserId(String userId);

    // Find bookings by destination
    List<Booking> findByDestinationId(String destinationId);

    // Find bookings by booking type
    List<Booking> findByBookingType(Enum bookingType);

    // Find bookings by status
    List<Booking> findByStatus(String status);
}
