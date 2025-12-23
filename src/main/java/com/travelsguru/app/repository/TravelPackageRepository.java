package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.TravelPackage;

@Repository
public interface TravelPackageRepository extends MongoRepository<TravelPackage, String>{

	List<TravelPackage> findByDestinationId(String destinationId);
}
