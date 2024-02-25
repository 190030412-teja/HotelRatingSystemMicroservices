package com.user.service.RatingService.services.Impl;

import com.user.service.RatingService.Entites.Rating;
import com.user.service.RatingService.repository.RatingRepo;
import com.user.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        String uid= UUID.randomUUID().toString();
        rating.setRatingId(uid);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String uid) {
        return ratingRepo.findByUserId(uid);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
