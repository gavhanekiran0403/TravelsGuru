package com.travelsguru.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.ReviewDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.ReviewMapper;
import com.travelsguru.app.model.Review;
import com.travelsguru.app.repository.ReviewRepository;
import com.travelsguru.app.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    // ================= ADD REVIEW =================
    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        reviewDto.setCreatedAt(LocalDateTime.now());
        Review review = reviewMapper.dtoToEntity(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.entityToDto(savedReview);
    }

    // ================= GET ALL REVIEWS =================
    @Override
    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::entityToDto)
                .collect(Collectors.toList());
    }

    // ================= GET REVIEWS BY PACKAGE =================
    @Override
    public List<ReviewDto> getReviewsByPackageId(String packageId) {
        return reviewRepository.findByTravelPackageId(packageId)
                .stream()
                .map(reviewMapper::entityToDto)
                .collect(Collectors.toList());
    }

    // ================= GET REVIEWS BY USER =================
    @Override
    public List<ReviewDto> getReviewsByUserId(String userId) {
        return reviewRepository.findByUserId(userId)
                .stream()
                .map(reviewMapper::entityToDto)
                .collect(Collectors.toList());
    }

    // ================= GET REVIEW BY ID =================
    @Override
    public ReviewDto getReviewById(String reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review", "reviewId", reviewId));
        return reviewMapper.entityToDto(review);
    }

    // ================= DELETE REVIEW =================
    @Override
    public String deleteReview(String reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review", "reviewId", reviewId));
        reviewRepository.delete(review);
        return "Review deleted successfully!";
    }
}
