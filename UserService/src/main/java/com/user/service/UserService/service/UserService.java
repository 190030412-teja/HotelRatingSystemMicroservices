package com.user.service.UserService.service;

import com.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {


    //create
    User saveUser(User user);
    //get all user
    List<User> getAllUser();
    //get single Use on ID
    User getUser(String uid);

}
