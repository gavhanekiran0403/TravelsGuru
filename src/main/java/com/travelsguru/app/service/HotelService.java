package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.HotelDto;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto updateHotel(String hotelId, HotelDto hotelDto);

    HotelDto getHotelById(String hotelId);

    List<HotelDto> getAllHotels();

    List<HotelDto> getHotelsByDestination(String destinationId);

    void deleteHotel(String hotelId);
}
