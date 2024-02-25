package com.user.service.UserService.controller;

import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //single user get
    @GetMapping("/{userid}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userid){
        User user=userService.getUser(userid);

        String url="http://RATING-SERVICE/ratings/users/"+user.getUserId();
        Rating[] ratings=restTemplate.getForObject(url, Rating[].class);
        List<Rating> ratings1= Arrays.stream(ratings).toList();
        log.info("recevied template: {}",ratings1);

        List<Rating> ratings2= ratings1.stream().map(rating -> {
           String ur="http://HOTEL-SERVICE/hotels/"+rating.getHotelId();
           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
           log.info("Hotels Data:{}",forEntity.getBody());
           rating.setHotel(forEntity.getBody());
           return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings2);
        return ResponseEntity.ok(user);
    }
    //all
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }
}
