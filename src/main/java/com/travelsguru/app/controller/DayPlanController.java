package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.DayPlanDto;
import com.travelsguru.app.service.DayPlanService;

@RestController
@RequestMapping("/api/day-plans")
public class DayPlanController {

    @Autowired
    private DayPlanService dayPlanService;

    // 1️⃣ Create DayPlan
    @PostMapping
    public ResponseEntity<DayPlanDto> createDayPlan(@RequestBody DayPlanDto dayPlanDto) {
        return ResponseEntity.ok(dayPlanService.createDayPlan(dayPlanDto));
    }

    // 2️⃣ Get DayPlan by Travel Package ID
    @GetMapping("/package/{packageId}")
    public ResponseEntity<DayPlanDto> getDayPlanByPackageId(@PathVariable String packageId) {
        return ResponseEntity.ok(dayPlanService.getDayPlanByPackageId(packageId));
    }

    // 3️⃣ Get All DayPlans
    @GetMapping
    public ResponseEntity<List<DayPlanDto>> getAllDayPlans() {
        return ResponseEntity.ok(dayPlanService.getAllDayPlans());
    }

    // 4️⃣ Update DayPlan
    @PutMapping("/{dayPlanId}")
    public ResponseEntity<DayPlanDto> updateDayPlan(
            @PathVariable String dayPlanId,
            @RequestBody DayPlanDto dayPlanDto) {

        return ResponseEntity.ok(dayPlanService.updateDayPlan(dayPlanId, dayPlanDto));
    }

    // 5️⃣ Delete DayPlan
    @DeleteMapping("/{dayPlanId}")
    public ResponseEntity<String> deleteDayPlan(@PathVariable String dayPlanId) {
        dayPlanService.deleteDayPlan(dayPlanId);
        return ResponseEntity.ok("DayPlan deleted successfully");
    }
}
