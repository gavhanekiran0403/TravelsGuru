package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.CityDto;

public interface CityService {

    CityDto createCity(CityDto cityDto);

    CityDto updateCity(String cityId, CityDto cityDto);

    CityDto getCityById(String cityId);

    List<CityDto> getAllCities();

    List<CityDto> getCitiesByDestination(String destinationId);

    void deleteCity(String cityId);
}
