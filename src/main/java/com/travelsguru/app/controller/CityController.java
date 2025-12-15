package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.CityDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.createCity(cityDto), HttpStatus.CREATED);
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityDto> updateCity(
            @PathVariable String cityId,
            @RequestBody CityDto cityDto) {
        return ResponseEntity.ok(cityService.updateCity(cityId, cityDto));
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDto> getCityById(@PathVariable String cityId) {
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<CityDto>> getCitiesByDestination(
            @PathVariable String destinationId) {
        return ResponseEntity.ok(cityService.getCitiesByDestination(destinationId));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<ApiResponse> deleteCity(@PathVariable String cityId) {
        cityService.deleteCity(cityId);
        return ResponseEntity.ok(new ApiResponse("City deleted successfully", true));
    }
}
