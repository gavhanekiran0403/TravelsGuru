package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelsguru.app.dto.DestinationCategoryDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.DestinationCategoryService;

@RestController
@RequestMapping("/api/categories")
public class DestinationCategoryController {

	@Autowired
	private DestinationCategoryService destinationCategoryService;
	
	@PostMapping
	public ResponseEntity<DestinationCategoryDto> createDestinationCategory(@RequestBody DestinationCategoryDto destinationCategoryDto){
		DestinationCategoryDto savedDestinationCategoryDto = destinationCategoryService.createDestinationCategory(destinationCategoryDto);
		return new ResponseEntity<DestinationCategoryDto>(savedDestinationCategoryDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{destiCategoryId}")
	public ResponseEntity<DestinationCategoryDto> updateDestinationCategory(@PathVariable String destiCategoryId, @RequestBody DestinationCategoryDto destinationCategoryDto){
		DestinationCategoryDto updatedDestinationCategoryDto = destinationCategoryService.updateDestinationCategory(destiCategoryId, destinationCategoryDto);
		return new ResponseEntity<DestinationCategoryDto>(updatedDestinationCategoryDto, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<DestinationCategoryDto>> getAllDestinationCategories(){
		List<DestinationCategoryDto> destinationCategoriesDtos = destinationCategoryService.getAllDestinationCategories();
		return new ResponseEntity<List<DestinationCategoryDto>>(destinationCategoriesDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{destiCategoryId}")
	public ResponseEntity<DestinationCategoryDto> getDestinationCategory(@PathVariable String destiCategoryId){
		DestinationCategoryDto destinationCategoryDto = destinationCategoryService.getDestinationCategoryById(destiCategoryId);
		return new ResponseEntity<DestinationCategoryDto>(destinationCategoryDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{destiCategoryId}")
	public ResponseEntity<ApiResponse> deleteDestinationCategory(@PathVariable String destiCategoryId){
		destinationCategoryService.deleteDestinationCategory(destiCategoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category delete successfully...", true), HttpStatus.OK);
	}
}
