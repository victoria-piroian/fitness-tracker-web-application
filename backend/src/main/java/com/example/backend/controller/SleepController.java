package com.example.backend.controller;

import com.example.backend.controller.exceptions.UserSleepNotFoundException;
import com.example.backend.model.entity.Sleep;
import com.example.backend.model.entity.UserSleepKey;
import com.example.backend.model.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SleepController {
    @Autowired
    private SleepRepository repository;

    public SleepController(SleepRepository repository){this.repository = repository;}

    @GetMapping("/sleep")
    List<Sleep> retrieveAllSleep() {
        return repository.findAll();
    }

    @PostMapping("/sleep")
    Sleep createSleep(@RequestBody Sleep newSleep) {
        return repository.save(newSleep);
    }

    @GetMapping("/sleep/{clientId}/{dayYear}")
    Sleep retrieveSleep(@PathVariable("clientId") Long clientId, @PathVariable("dayYear") String dayYear) {
        UserSleepKey userSleepKey = new UserSleepKey(clientId, dayYear);
        return repository.findById(userSleepKey)
                .orElseThrow(() -> new UserSleepNotFoundException(userSleepKey));
    }

    @PutMapping("/sleep/{clientId}/{dayYear}")
    Sleep updateSleep(@RequestBody Sleep newSleep, @PathVariable("clientId") Long clientId, @PathVariable("dayYear") String dayYear) {
        UserSleepKey userSleepKey = new UserSleepKey(clientId, dayYear);
        return repository.findById(userSleepKey)
                .map(sleep -> {
                    sleep.setDuration(newSleep.getDuration());
                    sleep.setRestScore(newSleep.getRestScore());
                    sleep.setDream(newSleep.getDream());
                    sleep.setAlarmWakeUp(newSleep.getAlarmWakeUp());
                    sleep.setNumNaps(newSleep.getNumNaps());
                    return repository.save(sleep);
                })
                .orElseThrow(() -> new UserSleepNotFoundException(userSleepKey));
    }

    @DeleteMapping("/sleep/{clientId}/{dayYear}")
    void deleteSleep(@PathVariable("clientId") Long clientId, @PathVariable("dayYear") String dayYear) {
        UserSleepKey userSleepKey = new UserSleepKey(clientId, dayYear);
        repository.deleteById(userSleepKey);
    }

    @GetMapping("/sleep/search/{searchString}")
    List<Sleep> searchUser(@PathVariable("searchString") String searchString) {return repository.searchByName(searchString);}

}