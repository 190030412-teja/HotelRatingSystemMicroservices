package com.user.service.HotelService.controllers;

import com.user.service.HotelService.entites.Hotel;
import com.user.service.HotelService.services.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
@Slf4j
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody  Hotel hotel){
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        log.info("Hotel request: {}",hotel);
        Hotel hotel1=hotelService.create(hotel);
        return ResponseEntity.ok(hotel1);
    }

    @GetMapping("/{hotelid}")
    public ResponseEntity<Hotel> returnSingleHotel(@PathVariable String hotelid){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingleHotel(hotelid));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }

}
