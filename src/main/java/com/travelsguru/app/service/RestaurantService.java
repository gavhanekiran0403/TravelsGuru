package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.RestaurantDto;

public interface RestaurantService {

    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    RestaurantDto updateRestaurant(String restaurantId, RestaurantDto restaurantDto);

    RestaurantDto getRestaurantById(String restaurantId);

    List<RestaurantDto> getAllRestaurants();

    List<RestaurantDto> getRestaurantsByDestination(String destinationId);

    void deleteRestaurant(String restaurantId);
}
