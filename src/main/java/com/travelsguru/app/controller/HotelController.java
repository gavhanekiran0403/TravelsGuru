package com.travelsguru.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.travelsguru.app.dto.HotelDto;
import com.travelsguru.app.exception.ApiResponse;
import com.travelsguru.app.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createHotel(
            @RequestBody HotelDto hotelDto) {
        return new ResponseEntity<>(
                hotelService.createHotel(hotelDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateHotel(
            @PathVariable String hotelId,
            @RequestBody HotelDto hotelDto) {
        return ResponseEntity.ok(
                hotelService.updateHotel(hotelId, hotelDto));
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(
            @PathVariable String hotelId) {
        return ResponseEntity.ok(
                hotelService.getHotelById(hotelId));
    }

    @GetMapping("/destination/{destinationId}")
    public ResponseEntity<List<HotelDto>> getHotelsByDestination(
            @PathVariable String destinationId) {
        return ResponseEntity.ok(
                hotelService.getHotelsByDestination(destinationId));
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ApiResponse> deleteHotel(
            @PathVariable String hotelId) {
        hotelService.deleteHotel(hotelId);
        return ResponseEntity.ok(
                new ApiResponse("Hotel deleted successfully", true));
    }
}
