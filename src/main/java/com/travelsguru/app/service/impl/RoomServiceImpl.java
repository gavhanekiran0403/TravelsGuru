package com.travelsguru.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.RoomDto;
import com.travelsguru.app.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public RoomDto addRoom(RoomDto dto) {
        // business logic will come here
        return dto;
    }

    @Override
    public RoomDto updateRoom(String id, RoomDto dto) {
        return dto;
    }

    @Override
    public RoomDto getRoomById(String id) {
        return null;
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return null;
    }

    @Override
    public void deleteRoom(String id) {
        // delete logic
    }
}
