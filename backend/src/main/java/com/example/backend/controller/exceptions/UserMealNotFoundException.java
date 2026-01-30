package com.example.backend.controller.exceptions;

import com.example.backend.model.entity.UserMealKey;

public class UserMealNotFoundException extends RuntimeException{
    public UserMealNotFoundException(UserMealKey userMealKey) {
        super("Could not find user meal key " + userMealKey);
    }
}