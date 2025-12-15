package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.RestaurantDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(
            @RequestBody RestaurantDto restaurantDto) {
        return new ResponseEntity<>(
                restaurantService.createRestaurant(restaurantDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> updateRestaurant(
            @PathVariable String restaurantId,
            @RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(
                restaurantService.updateRestaurant(restaurantId, restaurantDto));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurantById(
            @PathVariable String restaurantId) {
        return ResponseEntity.ok(
                restaurantService.getRestaurantById(restaurantId));
    }

    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByDestination(
            @PathVariable String destinationId) {
        return ResponseEntity.ok(
                restaurantService.getRestaurantsByDestination(destinationId));
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<ApiResponse> deleteRestaurant(
            @PathVariable String restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.ok(
                new ApiResponse("Restaurant deleted successfully", true));
    }
}
