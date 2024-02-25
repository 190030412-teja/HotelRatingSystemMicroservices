package com.user.service.HotelService.services;

import com.user.service.HotelService.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getSingleHotel(String hotel);

}
