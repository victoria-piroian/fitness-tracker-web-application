package com.example.backend.controller;

import com.example.backend.controller.exceptions.UserProgressNotFoundException;
import com.example.backend.model.entity.*;
import com.example.backend.model.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProgressController {
    @Autowired
    private ProgressRepository repository;

    public ProgressController(ProgressRepository repository){this.repository = repository;}

    @GetMapping("/progress")
    List<Progress> retrieveAllProgress() {
        return repository.findAll();
    }

    @PostMapping("/progress")
    Progress createProgress(@RequestBody Progress newProgress) {
        return repository.save(newProgress);
    }

    @GetMapping("/progress/{clientId}/{progressId}")
    Progress retreiveProgress(@PathVariable("clientId") Long clientId, @PathVariable("progressId") Long progressId) {
        UserProgressKey userProgressKey = new UserProgressKey(clientId, progressId);
        return repository.findById(userProgressKey)
                .orElseThrow(() -> new UserProgressNotFoundException(userProgressKey));
    }

    @PutMapping("/progress/{clientId}/{progressId}")
    Progress updateProgress(@RequestBody Progress newProgress, @PathVariable("clientId") Long clientId, @PathVariable("progressId") Long progressId) {
        UserProgressKey userProgressKey = new UserProgressKey(clientId, progressId);
        return repository.findById(userProgressKey)
                .map(progress -> {
                    progress.setGoal(newProgress.getGoal());
                    progress.setProgressScore(newProgress.getProgressScore());
                    progress.setReflection(newProgress.getReflection());
                    return repository.save(progress);
                })
                .orElseThrow(() -> new UserProgressNotFoundException(userProgressKey));
    }

    @DeleteMapping("/progress/{clientId}/{progressId}")
    void deleteProgress(@PathVariable("clientId") Long clientId, @PathVariable("progressId") Long progressId) {
        UserProgressKey userProgressKey = new UserProgressKey(clientId, progressId);
        repository.deleteById(userProgressKey);
    }

    @GetMapping("/progress/search/{searchString}")
    List<Progress> searchUser(@PathVariable("searchString") String searchString) {return repository.searchByName(searchString);}

}

