package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.TravelPackageDto;

public interface TravelPackageService {

	TravelPackageDto createPackage(TravelPackageDto travelPackageDto);

    TravelPackageDto updatePackage(String packageId, TravelPackageDto travelPackageDto);

    TravelPackageDto getPackageById(String packageId);

    List<TravelPackageDto> getAllPackages();

    void deletePackage(String packageId); 
}
