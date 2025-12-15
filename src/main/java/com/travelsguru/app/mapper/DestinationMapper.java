package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.DestinationDto;
import com.travelsguru.app.model.Destination;

@Component
public class DestinationMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Destination dtoToEntity(DestinationDto destinationDto) {
		return modelMapper.map(destinationDto, Destination.class);
	} 
	
	public DestinationDto entityToDto(Destination destination) {
		return modelMapper.map(destination, DestinationDto.class);
	} 
}
