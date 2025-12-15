package com.travelsguru.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.travelsguru.app.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>{

	List<Hotel> findByDestinationId(String destinationId);
}
