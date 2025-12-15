package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.DestinationDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.DestinationMapper;
import com.travelsguru.app.model.Destination;
import com.travelsguru.app.repository.DestinationRepository;
import com.travelsguru.app.service.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private DestinationMapper destinationMapper;

    @Override
    public DestinationDto createDestination(DestinationDto destinationDto) {
        Destination destination = destinationMapper.dtoToEntity(destinationDto);
        Destination saved = destinationRepository.save(destination);
        return destinationMapper.entityToDto(saved);
    }

    @Override
    public DestinationDto updateDestination(String destinationId, DestinationDto destinationDto) {
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", destinationId));

        destination.setDestinationName(destinationDto.getDestinationName());
        destination.setCountry(destinationDto.getCountry());
        destination.setImage(destinationDto.getImage());
        destination.setDescription(destinationDto.getDescription());
        destination.setDestiCategoryId(destinationDto.getDestiCategoryId());
        destination.setCityIds(destinationDto.getCityIds());
        destination.setHotelIds(destinationDto.getHotelIds());
        destination.setRestaurantIds(destinationDto.getRestaurantIds());
        destination.setActivityIds(destinationDto.getActivityIds());

        return destinationMapper.entityToDto(destinationRepository.save(destination));
    }

    @Override
    public List<DestinationDto> getAllDestinations() {
        return destinationRepository.findAll()
                .stream()
                .map(destinationMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationDto getDestinationById(String destinationId) {
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", destinationId));
        return destinationMapper.entityToDto(destination);
    }

    @Override
    public void deleteDestination(String destinationId) {
        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", destinationId));
        destinationRepository.delete(destination);
    }
}
