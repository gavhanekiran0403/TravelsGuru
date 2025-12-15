package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.DestinationDto;

public interface DestinationService {

	DestinationDto createDestination(DestinationDto destinationDto);
	
	DestinationDto updateDestination(String destinationId, DestinationDto destinationDto);
	
	List<DestinationDto> getAllDestinations();
	
	DestinationDto getDestinationById(String destinationId);
	
	void deleteDestination(String destinationId);
}
