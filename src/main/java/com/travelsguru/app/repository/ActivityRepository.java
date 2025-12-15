package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.Activity;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String>{

	List<Activity> findByDestinationId(String destinationId);
}
