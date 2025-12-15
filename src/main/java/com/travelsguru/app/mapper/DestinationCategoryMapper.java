package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.DestinationCategoryDto;
import com.travelsguru.app.model.DestinationCategory;

@Component
public class DestinationCategoryMapper {

	@Autowired
	 private ModelMapper modelMapper;
	
	public DestinationCategory dtoToEntity(DestinationCategoryDto dto) {
        return modelMapper.map(dto, DestinationCategory.class);
    }

	public DestinationCategoryDto entityToDto(DestinationCategory entity) {
        return modelMapper.map(entity, DestinationCategoryDto.class);
    }
}
