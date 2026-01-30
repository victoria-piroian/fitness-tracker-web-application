package com.example.backend.controller.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long clientId) {
        super("Could not find user " + clientId);
    }
}
