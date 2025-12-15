package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelsguru.app.model.City;

public interface CityRepository extends MongoRepository<City, String>{

	List<City> findByDestinationId(String destinationId);
}
