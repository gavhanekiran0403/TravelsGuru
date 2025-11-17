package com.travelsguru.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelsguru.app.model.DestinationCategory;
import com.travelsguru.app.repositories.DestinationCategoryRepository;
import com.travelsguru.app.service.DestinationCategoryService;

@RestController
@RequestMapping("/api/categories/")
public class DestinationCategoryController {

	@Autowired
	private DestinationCategoryService destinationCategoryService;
	
	@PostMapping("/add")
	public ResponseEntity<DestinationCategory> createDestinationCategory(@RequestBody DestinationCategory destinationCategory){
		DestinationCategory savedDestinationCategory = destinationCategoryService.createDestinationCategory(destinationCategory);
		return new ResponseEntity<DestinationCategory>(savedDestinationCategory, HttpStatus.CREATED);
	}
}
