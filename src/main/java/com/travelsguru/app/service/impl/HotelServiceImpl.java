package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.HotelDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.HotelMapper;
import com.travelsguru.app.model.Hotel;
import com.travelsguru.app.repository.DestinationRepository;
import com.travelsguru.app.repository.HotelRepository;
import com.travelsguru.app.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {

        destinationRepository.findById(hotelDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", hotelDto.getDestinationId()));

        Hotel hotel = hotelMapper.dtoToEntity(hotelDto);
        return hotelMapper.entityToDto(hotelRepository.save(hotel));
    }

    @Override
    public HotelDto updateHotel(String hotelId, HotelDto hotelDto) {

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel", "hotelId", hotelId));

        destinationRepository.findById(hotelDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", hotelDto.getDestinationId()));

        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setRating(hotelDto.getRating());
        hotel.setPricePerNight(hotelDto.getPricePerNight());
        hotel.setImage(hotelDto.getImage());
        hotel.setDestinationId(hotelDto.getDestinationId());

        return hotelMapper.entityToDto(hotelRepository.save(hotel));
    }

    @Override
    public HotelDto getHotelById(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel", "hotelId", hotelId));
        return hotelMapper.entityToDto(hotel);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelDto> getHotelsByDestination(String destinationId) {
        return hotelRepository.findByDestinationId(destinationId)
                .stream()
                .map(hotelMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHotel(String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Hotel", "hotelId", hotelId));
        hotelRepository.delete(hotel);
    }
}
