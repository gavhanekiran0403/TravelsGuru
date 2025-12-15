package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.ActivityDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityDto> createActivity(
            @RequestBody ActivityDto activityDto) {
        return new ResponseEntity<>(
                activityService.createActivity(activityDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<ActivityDto> updateActivity(
            @PathVariable String activityId,
            @RequestBody ActivityDto activityDto) {
        return ResponseEntity.ok(
                activityService.updateActivity(activityId, activityDto));
    }

    @GetMapping
    public ResponseEntity<List<ActivityDto>> getAllActivities() {
        return ResponseEntity.ok(activityService.getAllActivities());
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityDto> getActivityById(
            @PathVariable String activityId) {
        return ResponseEntity.ok(
                activityService.getActivityById(activityId));
    }

    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<ActivityDto>> getActivitiesByDestination(
            @PathVariable String destinationId) {
        return ResponseEntity.ok(
                activityService.getActivitiesByDestination(destinationId));
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<ApiResponse> deleteActivity(
            @PathVariable String activityId) {
        activityService.deleteActivity(activityId);
        return ResponseEntity.ok(
                new ApiResponse("Activity deleted successfully", true));
    }
}
