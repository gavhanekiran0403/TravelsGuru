package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.TravelPackageDto;
import com.travelsguru.app.model.TravelPackage;

@Component
public class TravelPackageMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public TravelPackage dtoToEntity(TravelPackageDto travelPackageDto) {
		return modelMapper.map(travelPackageDto, TravelPackage.class);
	}
	
	public TravelPackageDto entityToDto(TravelPackage travelPackage) {
		return modelMapper.map(travelPackage, TravelPackageDto.class);
	}
}
