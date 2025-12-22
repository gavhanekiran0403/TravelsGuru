package com.travelsguru.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelsguru.app.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{

}
