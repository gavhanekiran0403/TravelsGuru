package com.travelsguru.app.service;

import java.util.List;

import com.travelsguru.app.dto.RoomDto;

public interface RoomService {
	
    	RoomDto addRoom(RoomDto dto);
    	
    	RoomDto updateRoom (String id, RoomDto dto);
    	
    	RoomDto getRoomById(String id);
    	
    	List<RoomDto>  getAllRooms();
    	
    	void deleteRoom(String id);
    	
}
