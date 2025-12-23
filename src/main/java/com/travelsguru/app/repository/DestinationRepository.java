package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.Destination;

@Repository
public interface DestinationRepository extends MongoRepository<Destination, String> {

	List<Destination> findByDestiCategoryId(String destiCategoryId);
}
