package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.RestaurantDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.RestaurantMapper;
import com.travelsguru.app.model.Restaurant;
import com.travelsguru.app.repository.DestinationRepository;
import com.travelsguru.app.repository.RestaurantRepository;
import com.travelsguru.app.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {

        destinationRepository.findById(restaurantDto.getDestinationIds())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", restaurantDto.getDestinationIds()));

        Restaurant restaurant = restaurantMapper.dtoToEntity(restaurantDto);
        return restaurantMapper.entityToDto(restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantDto updateRestaurant(String restaurantId, RestaurantDto restaurantDto) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Restaurant", "restaurantId", restaurantId));

        destinationRepository.findById(restaurantDto.getDestinationIds())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", restaurantDto.getDestinationIds()));

        restaurant.setRestaurantName(restaurantDto.getRestaurantName());
        restaurant.setRating(restaurantDto.getRating());
        restaurant.setImage(restaurantDto.getImage());
        restaurant.setAverageCost(restaurantDto.getAverageCost());
        restaurant.setDestinationIds(restaurantDto.getDestinationIds());

        return restaurantMapper.entityToDto(
                restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantDto getRestaurantById(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Restaurant", "restaurantId", restaurantId));
        return restaurantMapper.entityToDto(restaurant);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDto> getRestaurantsByDestination(String destinationId) {
        return restaurantRepository.findByDestinationIds(destinationId)
                .stream()
                .map(restaurantMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Restaurant", "restaurantId", restaurantId));
        restaurantRepository.delete(restaurant);
    }
}
