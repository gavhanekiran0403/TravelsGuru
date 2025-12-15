package com.travelsguru.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.DestinationCategory;

@Repository
public interface DestinationCategoryRepository extends MongoRepository<DestinationCategory, String>{

}
