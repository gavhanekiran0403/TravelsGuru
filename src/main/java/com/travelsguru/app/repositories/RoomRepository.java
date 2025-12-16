package com.travelsguru.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelsguru.app.model.Room;

public interface RoomRepository extends MongoRepository<Room, String>{

}
