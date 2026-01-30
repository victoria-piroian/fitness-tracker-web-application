package com.example.backend.controller.exceptions;

import com.example.backend.model.entity.UserExerciseKey;

public class UserExerciseNotFoundException extends RuntimeException{
    public UserExerciseNotFoundException(UserExerciseKey userExerciseKey) {super("Could not find user exercise key " + userExerciseKey);
    }
}
