package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.ActivityDto;

public interface ActivityService {

    ActivityDto createActivity(ActivityDto activityDto);

    ActivityDto updateActivity(String activityId, ActivityDto activityDto);

    ActivityDto getActivityById(String activityId);

    List<ActivityDto> getAllActivities();

    List<ActivityDto> getActivitiesByDestination(String destinationId);

    void deleteActivity(String activityId);
}
