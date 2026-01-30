package com.example.backend.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Exercise")
public class Exercise {

    @EmbeddedId
    UserExerciseKey userExerciseKey;

    @NotEmpty
    private String workoutName;

    private float duration;

    @Max(5)
    @Min(0)
    private int satisfaction;

    public Exercise(UserExerciseKey userExerciseKey, String workoutName, float duration, int satisfaction) {
        this.userExerciseKey = userExerciseKey;
        this.workoutName = workoutName;
        this.duration = duration;
        this.satisfaction = satisfaction;
    }

}
