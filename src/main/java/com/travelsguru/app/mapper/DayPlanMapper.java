package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.DayPlanDto;
import com.travelsguru.app.model.DayPlan;

@Component
public class DayPlanMapper {

    @Autowired
    private ModelMapper modelMapper;

    // 🔹 DTO → Entity
    public DayPlan toEntity(DayPlanDto dto) {
        return modelMapper.map(dto, DayPlan.class);
    }

    // 🔹 Entity → DTO
    public DayPlanDto toDto(DayPlan entity) {
        return modelMapper.map(entity, DayPlanDto.class);
    }
}
