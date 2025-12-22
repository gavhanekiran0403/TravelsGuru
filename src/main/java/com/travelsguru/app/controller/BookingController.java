package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.BookingDto;
import com.travelsguru.app.enums.BookingType;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create booking
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        return new ResponseEntity<>(bookingService.createBooking(bookingDto), HttpStatus.CREATED);
    }

    // Update booking
    @PutMapping("/{bookingId}")
    public ResponseEntity<BookingDto> updateBooking(
            @PathVariable String bookingId,
            @RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, bookingDto));
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Get booking by id
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable String bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    // Get bookings by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDto>> getBookingsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }

    // Get bookings by destination
    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<BookingDto>> getBookingsByDestination(
            @PathVariable String destinationId) {
        return ResponseEntity.ok(bookingService.getBookingsByDestination(destinationId));
    }

    // Get bookings by booking type
    @GetMapping("/type/{bookingType}")
    public ResponseEntity<List<BookingDto>> getBookingsByType(
            @PathVariable BookingType bookingType) {
        return ResponseEntity.ok(bookingService.getBookingsByType(bookingType));
    }

    // Get bookings by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BookingDto>> getBookingsByStatus(
            @PathVariable String status) {
        return ResponseEntity.ok(bookingService.getBookingsByStatus(status));
    }

    // Cancel booking
    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<ApiResponse> cancelBooking(@PathVariable String bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(new ApiResponse("Booking cancelled successfully", true));
    }
}
