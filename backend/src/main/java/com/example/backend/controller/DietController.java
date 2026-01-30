package com.example.backend.controller;

import com.example.backend.controller.exceptions.UserMealNotFoundException;
import com.example.backend.model.entity.Diet;
import com.example.backend.model.entity.UserMealKey;
import com.example.backend.model.repository.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DietController {
    @Autowired
    private DietRepository repository;

    public DietController(DietRepository repository){
        this.repository = repository;
    }

    @GetMapping("/diet/{clientId}")
    List<Diet> retrieveWantedInfo(@PathVariable("clientId") long clientId) {
        repository.findWantedInfo(clientId);
        return repository.findWantedInfo(clientId);
    }

    @GetMapping("/diet")
    List<Diet> retrieveAllDiet() {
        return repository.findAll();
    }


    @PostMapping("/diet")
    Diet createDiet(@RequestBody Diet newDiet) {
        return repository.save(newDiet);
    }

    @GetMapping("/diet/{clientId}/{mealType}/{dayYear}")
    Diet retrieveDiet(@PathVariable("clientId") Long clientId, @PathVariable("mealType") String mealType, @PathVariable("dayYear") String dayYear) {
        UserMealKey userMealKey = new UserMealKey(clientId, mealType, dayYear);
        return repository.findById(userMealKey)
                .orElseThrow(() -> new UserMealNotFoundException(userMealKey));
    }

    @PutMapping("/diet/{clientId}/{mealType}/{dayYear}")
    Diet updateDiet(@RequestBody Diet newDiet, @PathVariable("clientId") Long clientId, @PathVariable("mealType") String mealType, @PathVariable("dayYear") String dayYear) {
        UserMealKey userMealKey = new UserMealKey(clientId, mealType, dayYear);
        return repository.findById(userMealKey)
                .map(diet -> {
                    diet.setMealName(newDiet.getMealName());
                    diet.setCalories(newDiet.getCalories());
                    diet.setSugar(newDiet.getSugar());
                    diet.setCarbs(newDiet.getCarbs());
                    diet.setProtein(newDiet.getProtein());
                    diet.setFat(newDiet.getFat());
                    return repository.save(diet);
                })
                .orElseThrow(() -> new UserMealNotFoundException(userMealKey));
    }

    @DeleteMapping("/diet/{clientId}/{mealType}/{dayYear}")
    void deleteDiet(@PathVariable("clientId") Long clientId, @PathVariable("mealType") String mealType, @PathVariable("dayYear") String dayYear) {
        UserMealKey userMealKey = new UserMealKey(clientId, mealType, dayYear);
        repository.deleteById(userMealKey);
    }

    @GetMapping("/diet/search/{searchString}")
    List<Diet> searchUser(@PathVariable("searchString") String searchString) {return repository.searchByName(searchString);}
}