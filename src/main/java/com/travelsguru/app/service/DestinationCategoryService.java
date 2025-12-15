package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.DestinationCategoryDto;

public interface DestinationCategoryService {

	DestinationCategoryDto createDestinationCategory(DestinationCategoryDto destinationCategoryDto);
	
	DestinationCategoryDto updateDestinationCategory(String destiCategoryId, DestinationCategoryDto destinationCategoryDto);
	
	List<DestinationCategoryDto> getAllDestinationCategories();
	
	DestinationCategoryDto getDestinationCategoryById(String destiCategoryId);
	
	void deleteDestinationCategory(String destiCategoryId);
	
}
