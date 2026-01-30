package com.example.backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UserExerciseKey implements Serializable {

    @Column(name = "clientId")
    Long clientId;

    private Long workoutId;

    private String dayYear;


    @Override
    public int hashCode() {
        String concatString = String.valueOf(clientId.hashCode()) + String.valueOf(workoutId.hashCode()) + String.valueOf(dayYear.hashCode());
        return concatString.hashCode();
    }
    public UserExerciseKey(){}

    public UserExerciseKey(Long clientId, Long workoutId, String dayYear){
        this.setClientId(clientId);
        this.setWorkoutId(workoutId);
        this.setDayYear(dayYear);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof UserExerciseKey))
            return false;
        UserExerciseKey other = (UserExerciseKey) o;
        return clientId.equals(other.clientId) && workoutId.equals(other.workoutId) && dayYear.equals(other.dayYear);
    }

}
