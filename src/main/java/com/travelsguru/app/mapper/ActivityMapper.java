package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.ActivityDto;
import com.travelsguru.app.model.Activity;

@Component
public class ActivityMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public Activity dtoToEntity(ActivityDto activityDto) {
		return modelMapper.map(activityDto, Activity.class);	
	}
	
	public ActivityDto entityToDto(Activity activity) {
		return modelMapper.map(activity, ActivityDto.class);
	}
}
