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

import com.travelsguru.app.dto.DestinationDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.DestinationService;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

	@Autowired
	private DestinationService destinationService;
	
	@PostMapping
	public ResponseEntity<DestinationDto> createDestination(@RequestBody DestinationDto destinationDto) {
		DestinationDto savedDestinationDto = destinationService.createDestination(destinationDto);
		return new ResponseEntity<DestinationDto>(savedDestinationDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{destinationId}")
	public ResponseEntity<DestinationDto> updateDestination(@PathVariable String destinationId, @RequestBody DestinationDto destinationDto) {
		DestinationDto updatedDestinationDto = destinationService.updateDestination(destinationId, destinationDto);
		return new ResponseEntity<DestinationDto>(updatedDestinationDto, HttpStatus.OK);
	}
	
	@GetMapping
    public ResponseEntity<List<DestinationDto>> getAllDestinations() {
        List<DestinationDto> destinationDtos = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinationDtos, HttpStatus.OK);
    }

    @GetMapping("/{destinationId}")
    public ResponseEntity<DestinationDto> getDestinationById(@PathVariable String destinationId) {
        DestinationDto destinationDto = destinationService.getDestinationById(destinationId);
        return new ResponseEntity<>(destinationDto, HttpStatus.OK);
    }
    
    @DeleteMapping("/{destinationId}")
    public ResponseEntity<ApiResponse> deleteDestination(@PathVariable String destinationId) {
        destinationService.deleteDestination(destinationId);
        return new ResponseEntity<>(new ApiResponse("Destination deleted successfully...", true), HttpStatus.OK);
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DestinationDto>> getDestinationsByCategory(
            @PathVariable String categoryId) {
    	List<DestinationDto> destinationDtos = destinationService.getDestinationsByCategory(categoryId);
        return new ResponseEntity<>(destinationDtos, HttpStatus.OK);
    }

}
