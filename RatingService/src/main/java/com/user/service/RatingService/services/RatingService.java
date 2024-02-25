package com.user.service.RatingService.services;

import com.user.service.RatingService.Entites.Rating;

import java.util.List;

public interface RatingService {


    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(String uid);

    List<Rating> getRatingByHotelId(String hotelId);

}
