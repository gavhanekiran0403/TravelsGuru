package com.travelsguru.app.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travelsguru.app.dto.ReviewDto;
import com.travelsguru.app.model.Review;

@Component
public class ReviewMapper {

    @Autowired
    private ModelMapper modelMapper;

    // DTO → Entity
    public Review dtoToEntity(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }

    // Entity → DTO
    public ReviewDto entityToDto(Review review) {
        return modelMapper.map(review, ReviewDto.class);
    }
}
