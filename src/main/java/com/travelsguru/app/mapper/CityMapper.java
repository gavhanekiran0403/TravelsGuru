package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.CityDto;
import com.travelsguru.app.model.City;

@Component
public class CityMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public City dtoToEntity(CityDto cityDto) {
		return modelMapper.map(cityDto, City.class);	
	}
	
	public CityDto entityToDto(City city) {
		return modelMapper.map(city, CityDto.class);
	}
}
