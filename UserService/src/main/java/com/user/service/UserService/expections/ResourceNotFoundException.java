package com.user.service.UserService.expections;

public class ResourceNotFoundException extends  RuntimeException{


    public ResourceNotFoundException(){
        super("Resource not Found...");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }

}
