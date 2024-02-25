package com.user.service.RatingService.repository;

import com.user.service.RatingService.Entites.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {

    //custom find Methods.
    List<Rating> findByUserId(String uid);

    List<Rating> findByHotelId(String uid);

}
