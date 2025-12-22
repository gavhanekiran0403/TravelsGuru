package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.BookingDto;
import com.travelsguru.app.model.Booking;

@Component
public class BookingMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Booking dtoToEntity(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, Booking.class);
    }

    public BookingDto entityToDto(Booking booking) {
        return modelMapper.map(booking, BookingDto.class);
    }
}
