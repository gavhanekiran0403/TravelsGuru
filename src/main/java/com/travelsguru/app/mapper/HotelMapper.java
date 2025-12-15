package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.HotelDto;
import com.travelsguru.app.model.Hotel;

@Component
public class HotelMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Hotel dtoToEntity(HotelDto hotelDto) {
		return modelMapper.map(hotelDto, Hotel.class);
	}
	
	public HotelDto entityToDto(Hotel hotel) {
		return modelMapper.map(hotel, HotelDto.class);
	}
}
