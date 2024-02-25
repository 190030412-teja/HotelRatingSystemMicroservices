package com.user.service.HotelService.exceptions;

import org.springframework.stereotype.Service;

@Service
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource Not found...");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
