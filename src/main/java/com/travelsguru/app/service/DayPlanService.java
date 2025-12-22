package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.DayPlanDto;

public interface DayPlanService {

    // 1️⃣ Create DayPlan
    DayPlanDto createDayPlan(DayPlanDto dayPlanDto);

    // 2️⃣ Get DayPlan by Travel Package ID
    DayPlanDto getDayPlanByPackageId(String travelPackageId);

    // 3️⃣ Get All DayPlans
    List<DayPlanDto> getAllDayPlans();

    // 4️⃣ Update DayPlan
    DayPlanDto updateDayPlan(String dayPlanId, DayPlanDto dayPlanDto);

    // 5️⃣ Delete DayPlan
    void deleteDayPlan(String dayPlanId);
}
