package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.RestaurantDto;
import com.travelsguru.app.model.Restaurant;

@Component
public class RestaurantMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Restaurant dtoToEntity(RestaurantDto restaurantDto) {
		return modelMapper.map(restaurantDto, Restaurant.class);
	}
	
	public RestaurantDto entityToDto(Restaurant restaurant) {
		return modelMapper.map(restaurant, RestaurantDto.class);
	}
}
