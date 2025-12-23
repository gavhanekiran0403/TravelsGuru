package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.ReviewDto;

public interface ReviewService {

    ReviewDto addReview(ReviewDto reviewDto);

    List<ReviewDto> getAllReviews();          

    List<ReviewDto> getReviewsByPackageId(String packageId);

    List<ReviewDto> getReviewsByUserId(String userId);

    ReviewDto getReviewById(String reviewId);

    String deleteReview(String reviewId);
}
