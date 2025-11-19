package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.model.DestinationCategory;

public interface DestinationCategoryService {

	public DestinationCategory createDestinationCategory(DestinationCategory destinationCategory);
	
	public DestinationCategory updateDestinationCategory(String destiCategoryId, DestinationCategory destinationCategory);
	
	public List<DestinationCategory> getAllDestinationCategory();
	
	public DestinationCategory getDestinationCategoryById(String destiCategoryId);
	
	public void deleteDestinationCategory(String destiCategoryId);
	
}
