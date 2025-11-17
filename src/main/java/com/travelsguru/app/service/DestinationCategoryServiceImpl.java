package com.travelsguru.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.model.DestinationCategory;
import com.travelsguru.app.repositories.DestinationCategoryRepository;

@Service
public class DestinationCategoryServiceImpl implements DestinationCategoryService {

	@Autowired
	private DestinationCategoryRepository destinationCategoryRepository;
	
	@Override
	public DestinationCategory createDestinationCategory(DestinationCategory destinationCategory) {
		DestinationCategory savedDestinationCategory = destinationCategoryRepository.save(destinationCategory);
		return savedDestinationCategory;
	}

}
