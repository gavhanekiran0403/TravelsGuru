package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.TravelPackageDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.TravelPackageMapper;
import com.travelsguru.app.model.TravelPackage;
import com.travelsguru.app.repository.TravelPackageRepository;
import com.travelsguru.app.service.TravelPackageService;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    private TravelPackageMapper travelPackageMapper;

    @Override
    public TravelPackageDto createPackage(TravelPackageDto travelPackageDto) {
        TravelPackage travelPackage = travelPackageMapper.dtoToEntity(travelPackageDto);
        TravelPackage saved = travelPackageRepository.save(travelPackage);
        return travelPackageMapper.entityToDto(saved);
    }

    @Override
    public TravelPackageDto updatePackage(String packageId, TravelPackageDto travelPackageDto) {
        TravelPackage travelPackage = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "TravelPackage", "packageId", packageId));

        travelPackage.setPackageTitle(travelPackageDto.getPackageTitle());
        travelPackage.setPrice(travelPackageDto.getPrice());
        travelPackage.setDays(travelPackageDto.getDays());
        travelPackage.setNights(travelPackageDto.getNights());
        travelPackage.setDescription(travelPackageDto.getDescription());
        travelPackage.setDestinationId(travelPackageDto.getDestinationId());
        travelPackage.setCityIds(travelPackageDto.getCityIds());
        travelPackage.setHotelIds(travelPackageDto.getHotelIds());
        travelPackage.setActivityIds(travelPackageDto.getActivityIds());
        travelPackage.setDayPlanIds(travelPackageDto.getDayPlanIds());

        return travelPackageMapper.entityToDto(
                travelPackageRepository.save(travelPackage));
    }

    @Override
    public TravelPackageDto getPackageById(String packageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "TravelPackage", "packageId", packageId));

        return travelPackageMapper.entityToDto(travelPackage);
    }

    @Override
    public List<TravelPackageDto> getAllPackages() {
        return travelPackageRepository.findAll()
                .stream()
                .map(travelPackageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePackage(String packageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(packageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "TravelPackage", "packageId", packageId));

        travelPackageRepository.delete(travelPackage);
    }
}
