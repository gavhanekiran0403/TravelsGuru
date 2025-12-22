package com.travelsguru.app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelsguru.app.model.DayPlan;

public interface DayPlanRepository extends MongoRepository<DayPlan, String> {

    Optional<DayPlan> findByTravelPackageId(String travelPackageId);
}
