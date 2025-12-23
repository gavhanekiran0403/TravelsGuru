package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByTravelPackageId(String travelPackageId);

    List<Review> findByUserId(String userId);
}
