package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.BookingDto;
import com.travelsguru.app.enums.BookingType;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.BookingMapper;
import com.travelsguru.app.model.Booking;
import com.travelsguru.app.repository.BookingRepository;
import com.travelsguru.app.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        Booking booking = bookingMapper.dtoToEntity(bookingDto);
        booking.setStatus("CONFIRMED");

        return bookingMapper.entityToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto updateBooking(String bookingId, BookingDto bookingDto) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking", "bookingId", bookingId));

        booking.setBookingType(bookingDto.getBookingType());
        booking.setTravellerType(bookingDto.getTravellerType());
        booking.setDepartureLocation(bookingDto.getDepartureLocation());
        booking.setDuration(bookingDto.getDuration());
        booking.setStartDate(bookingDto.getStartDate());
        booking.setActivityIds(bookingDto.getActivityIds());
        booking.setHotelIds(bookingDto.getHotelIds());
        booking.setDestinationId(bookingDto.getDestinationId());
        booking.setTravelPackageId(bookingDto.getTravelPackageId());
        booking.setUserId(bookingDto.getUserId());
        booking.setTotalAmount(bookingDto.getTotalAmount());
        booking.setStatus(bookingDto.getStatus());

        return bookingMapper.entityToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getBookingById(String bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking", "bookingId", bookingId));

        return bookingMapper.entityToDto(booking);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByUser(String userId) {
        return bookingRepository.findByUserId(userId)
                .stream()
                .map(bookingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByDestination(String destinationId) {
        return bookingRepository.findByDestinationId(destinationId)
                .stream()
                .map(bookingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByType(BookingType bookingType) {
        return bookingRepository.findByBookingType(bookingType)
                .stream()
                .map(bookingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDto> getBookingsByStatus(String status) {
        return bookingRepository.findByStatus(status)
                .stream()
                .map(bookingMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelBooking(String bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Booking", "bookingId", bookingId));

        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }
}
