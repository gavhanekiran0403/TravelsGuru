package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.CityDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.CityMapper;
import com.travelsguru.app.model.City;
import com.travelsguru.app.repository.CityRepository;
import com.travelsguru.app.repository.DestinationRepository;
import com.travelsguru.app.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public CityDto createCity(CityDto cityDto) {
    	
        destinationRepository.findById(cityDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", cityDto.getDestinationId()));

        City city = cityMapper.dtoToEntity(cityDto);
        return cityMapper.entityToDto(cityRepository.save(city));
    }

    @Override
    public CityDto updateCity(String cityId, CityDto cityDto) {

        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "City", "cityId", cityId));

        destinationRepository.findById(cityDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", cityDto.getDestinationId()));

        city.setCityName(cityDto.getCityName());
        city.setDescription(cityDto.getDescription());
        city.setImage(cityDto.getImage());
        city.setDestinationId(cityDto.getDestinationId());

        return cityMapper.entityToDto(cityRepository.save(city));
    }

    @Override
    public CityDto getCityById(String cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "City", "cityId", cityId));
        return cityMapper.entityToDto(city);
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(cityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDto> getCitiesByDestination(String destinationId) {
        return cityRepository.findByDestinationId(destinationId)
                .stream()
                .map(cityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCity(String cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "City", "cityId", cityId));
        cityRepository.delete(city);
    }
}
