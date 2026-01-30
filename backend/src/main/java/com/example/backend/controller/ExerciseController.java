package com.example.backend.controller;

import com.example.backend.controller.exceptions.UserExerciseNotFoundException;
import com.example.backend.model.entity.*;
import com.example.backend.model.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExerciseController {
    @Autowired
    private ExerciseRepository repository;

    public ExerciseController(ExerciseRepository repository){this.repository = repository;}

    @GetMapping("/exercise")
    List<Exercise> retrieveAllExercises() {return repository.findAll();}

    @PostMapping("/exercise")
    Exercise createExercise(@RequestBody Exercise newExercise) {
        return repository.save(newExercise);
    }

    @GetMapping("/exercise/{clientId}/{workoutId}/{dayYear}")
    Exercise retrieveExercise(@PathVariable("clientId") Long clientId, @PathVariable("workoutId") Long workoutId, @PathVariable("dayYear") String dayYear) {
        UserExerciseKey userExerciseKey = new UserExerciseKey(clientId, workoutId, dayYear);
        return repository.findById(userExerciseKey)
                .orElseThrow(() -> new UserExerciseNotFoundException(userExerciseKey));
    }

    @PutMapping("/exercise/{clientId}/{workoutId}/{dayYear}")
    Exercise updateExercise(@RequestBody Exercise newExercise, @PathVariable("clientId") Long clientId, @PathVariable("workoutId") Long workoutId, @PathVariable("dayYear") String dayYear) {
        UserExerciseKey userExerciseKey = new UserExerciseKey(clientId, workoutId, dayYear);
        return repository.findById(userExerciseKey)
                .map(exercise -> {
                    exercise.setWorkoutName(newExercise.getWorkoutName());
                    exercise.setDuration(newExercise.getDuration());
                    exercise.setSatisfaction(newExercise.getSatisfaction());
                    return repository.save(exercise);
                })
                .orElseThrow(() -> new UserExerciseNotFoundException(userExerciseKey));
    }

    @DeleteMapping("/exercise/{clientId}/{workoutId}/{dayYear}")
    void deleteDiet(@PathVariable("clientId") Long clientId, @PathVariable("workoutId") Long workoutId, @PathVariable("dayYear") String dayYear) {
        UserExerciseKey userExerciseKey = new UserExerciseKey(clientId, workoutId, dayYear);
        repository.deleteById(userExerciseKey);
    }

    @GetMapping("/exercise/search/{searchString}")
    List<Exercise> searchUser(@PathVariable("searchString") String searchString) {return repository.searchByName(searchString);}
}

