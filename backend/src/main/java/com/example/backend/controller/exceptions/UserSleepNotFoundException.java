package com.example.backend.controller.exceptions;

import com.example.backend.model.entity.UserSleepKey;

public class UserSleepNotFoundException extends RuntimeException{
    public UserSleepNotFoundException(UserSleepKey userSleepKey) {super("Could not find user sleep key " + userSleepKey);
    }
}