package com.user.service.UserService.service.Impl;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.expections.ResourceNotFoundException;
import com.user.service.UserService.repositories.UserRepository;
import com.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String uuid=UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String uid) {
        return userRepository.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User not found with user id: "+uid));
    }
}
