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

import com.travelsguru.app.dto.TravelPackageDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.TravelPackageService;

@RestController
@RequestMapping("/api/travel-packages/")
public class TravelPackageController {

	@Autowired
	private TravelPackageService travelPackageService;

	@PostMapping("/")
	public ResponseEntity<TravelPackageDto> createTravelPackage(@RequestBody TravelPackageDto travelPackageDto) {
		TravelPackageDto createdPackage = travelPackageService.createPackage(travelPackageDto);
		return new ResponseEntity<>(createdPackage, HttpStatus.CREATED);
	}

	@PutMapping("/{packageId}")
	public ResponseEntity<TravelPackageDto> updateTravelPackage(@PathVariable String packageId,
			@RequestBody TravelPackageDto travelPackageDto) {

		TravelPackageDto updatedPackage = travelPackageService.updatePackage(packageId, travelPackageDto);
		return new ResponseEntity<>(updatedPackage, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<TravelPackageDto>> getAllTravelPackages() {
		List<TravelPackageDto> travelPackages = travelPackageService.getAllPackages();
		return new ResponseEntity<>(travelPackages, HttpStatus.OK);
	}

	@GetMapping("/{packageId}")
	public ResponseEntity<TravelPackageDto> getTravelPackageById(@PathVariable String packageId) {
		TravelPackageDto travelPackage = travelPackageService.getPackageById(packageId);
		return new ResponseEntity<>(travelPackage, HttpStatus.OK);
	}

	@DeleteMapping("/{packageId}")
	public ResponseEntity<ApiResponse> deleteTravelPackage(@PathVariable String packageId) {
		travelPackageService.deletePackage(packageId);
		return new ResponseEntity<>(new ApiResponse("Travel package deleted successfully",  true), HttpStatus.OK);
	}

}
