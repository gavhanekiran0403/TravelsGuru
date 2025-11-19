package com.travelsguru.app.service;

import java.util.List;

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
		return destinationCategoryRepository.save(destinationCategory);
	}

	@Override
	public DestinationCategory updateDestinationCategory(String destiCategoryId,
			DestinationCategory destinationCategory) {
		
		DestinationCategory existingDestinationCategory = destinationCategoryRepository.findById(destiCategoryId).orElse(null);
		existingDestinationCategory.setDestiCategoryId(destinationCategory.getDestiCategoryId());
		existingDestinationCategory.setDestiCategoryName(destinationCategory.getDestiCategoryName());
		existingDestinationCategory.setImage(destinationCategory.getImage());
		existingDestinationCategory.setDescription(destinationCategory.getDescription());
		
		return destinationCategoryRepository.save(existingDestinationCategory);
	}

	@Override
	public List<DestinationCategory> getAllDestinationCategory() {
		return destinationCategoryRepository.findAll();
	}

	@Override
	public DestinationCategory getDestinationCategoryById(String destiCategoryId) {
		destinationCategoryRepository.findById(destiCategoryId).orElse(null);
		return null;
	}

	@Override
	public void deleteDestinationCategory(String destiCategoryId) {

		
	}

}
