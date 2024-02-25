package com.user.service.HotelService.services.impl;

import com.user.service.HotelService.entites.Hotel;
import com.user.service.HotelService.exceptions.ResourceNotFoundException;
import com.user.service.HotelService.repositories.HotelRepo;
import com.user.service.HotelService.services.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        log.info("Hotel data:{}",hotel);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getSingleHotel(String str) {
        return hotelRepo.findById(str).orElseThrow(()-> new ResourceNotFoundException("Hotel with given Id is not found.."));
    }
}
