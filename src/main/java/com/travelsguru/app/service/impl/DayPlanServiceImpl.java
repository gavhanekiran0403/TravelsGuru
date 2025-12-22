package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.DayPlanDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.DayPlanMapper;
import com.travelsguru.app.model.DayPlan;
import com.travelsguru.app.repository.DayPlanRepository;
import com.travelsguru.app.service.DayPlanService;

@Service
public class DayPlanServiceImpl implements DayPlanService {

    @Autowired
    private DayPlanRepository dayPlanRepository;

    @Autowired
    private DayPlanMapper dayPlanMapper;

    // 1️⃣ Create DayPlan
    @Override
    public DayPlanDto createDayPlan(DayPlanDto dayPlanDto) {
        DayPlan dayPlan = dayPlanMapper.toEntity(dayPlanDto);
        DayPlan savedDayPlan = dayPlanRepository.save(dayPlan);
        return dayPlanMapper.toDto(savedDayPlan);
    }

    // 2️⃣ Get DayPlan by Travel Package ID
    @Override
    public DayPlanDto getDayPlanByPackageId(String travelPackageId) {
        DayPlan dayPlan = dayPlanRepository.findByTravelPackageId(travelPackageId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DayPlan", "travelPackageId", travelPackageId));

        return dayPlanMapper.toDto(dayPlan);
    }

    // 3️⃣ Get All DayPlans
    @Override
    public List<DayPlanDto> getAllDayPlans() {
        return dayPlanRepository.findAll()
                .stream()
                .map(dayPlanMapper::toDto)
                .collect(Collectors.toList());
    }

    // 4️⃣ Update DayPlan
    @Override
    public DayPlanDto updateDayPlan(String dayPlanId, DayPlanDto dayPlanDto) {

        DayPlan existingDayPlan = dayPlanRepository.findById(dayPlanId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DayPlan", "dayPlanId", dayPlanId));

        // Update simple field
        existingDayPlan.setTravelPackageId(dayPlanDto.getTravelPackageId());

        // ✅ Convert DTO days → Entity days using mapper
        DayPlan updatedData = dayPlanMapper.toEntity(dayPlanDto);
        existingDayPlan.setDays(updatedData.getDays());

        DayPlan savedDayPlan = dayPlanRepository.save(existingDayPlan);
        return dayPlanMapper.toDto(savedDayPlan);
    }


    // 5️⃣ Delete DayPlan
    @Override
    public void deleteDayPlan(String dayPlanId) {
        DayPlan existingDayPlan = dayPlanRepository.findById(dayPlanId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DayPlan", "dayPlanId", dayPlanId));

        dayPlanRepository.delete(existingDayPlan);
    }
}
