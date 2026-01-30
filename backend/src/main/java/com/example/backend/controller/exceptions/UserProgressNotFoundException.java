package com.example.backend.controller.exceptions;

import com.example.backend.model.entity.UserProgressKey;

public class UserProgressNotFoundException extends RuntimeException{
    public UserProgressNotFoundException(UserProgressKey userProgressKey) {super("Could not find user exercise key " + userProgressKey);
    }
}
