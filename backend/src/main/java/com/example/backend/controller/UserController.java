package com.example.backend.controller;

import com.example.backend.controller.exceptions.UserNotFoundException;
import com.example.backend.model.entity.User;
import com.example.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository){this.repository = repository;}

    @GetMapping("/user")
    List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/user")
    User createUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/user/{clientId}")
    User retrieveUser(@PathVariable("clientId") long clientId) {
        return repository.findById(clientId)
                .orElseThrow(() -> new UserNotFoundException(clientId));
    }


    @PutMapping("/user/{clientId}")
    User updateUser(@RequestBody User newUser, @PathVariable("clientId") Long clientId) {
        return repository.findById(clientId)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setHeight(newUser.getHeight());
                    user.setAge(newUser.getAge());
                    user.setWeight(newUser.getWeight());
                    return repository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(clientId));
    }

    @DeleteMapping("/user/{clientId}")
    void deleteUser(@PathVariable("clientId") Long clientId) {repository.deleteById(clientId);
    }

    @GetMapping("/user/search/{searchString}")
    List<User> searchUser(@PathVariable("searchString") String searchString) {return repository.searchByName(searchString);}
}

