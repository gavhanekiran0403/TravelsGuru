package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.ActivityDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.ActivityMapper;
import com.travelsguru.app.model.Activity;
import com.travelsguru.app.repository.ActivityRepository;
import com.travelsguru.app.repository.DestinationRepository;
import com.travelsguru.app.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public ActivityDto createActivity(ActivityDto activityDto) {

        destinationRepository.findById(activityDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", activityDto.getDestinationId()));

        Activity activity = activityMapper.dtoToEntity(activityDto);
        return activityMapper.entityToDto(activityRepository.save(activity));
    }

    @Override
    public ActivityDto updateActivity(String activityId, ActivityDto activityDto) {

        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Activity", "activityId", activityId));

        destinationRepository.findById(activityDto.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Destination", "destinationId", activityDto.getDestinationId()));

        activity.setActivityTitle(activityDto.getActivityTitle());
        activity.setPrice(activityDto.getPrice());
        activity.setImage(activityDto.getImage());
        activity.setDestinationId(activityDto.getDestinationId());

        return activityMapper.entityToDto(activityRepository.save(activity));
    }

    @Override
    public ActivityDto getActivityById(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Activity", "activityId", activityId));
        return activityMapper.entityToDto(activity);
    }

    @Override
    public List<ActivityDto> getAllActivities() {
        return activityRepository.findAll()
                .stream()
                .map(activityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ActivityDto> getActivitiesByDestination(String destinationId) {
        return activityRepository.findByDestinationId(destinationId)
                .stream()
                .map(activityMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteActivity(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Activity", "activityId", activityId));
        activityRepository.delete(activity);
    }
}
