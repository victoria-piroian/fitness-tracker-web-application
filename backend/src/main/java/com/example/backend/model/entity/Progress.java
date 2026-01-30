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
@Table(name = "Progress")
public class Progress {

    @EmbeddedId
    UserProgressKey userProgressKey;

    @NotEmpty
    private String goal;

    @Max(5)
    @Min(0)
    private int progressScore;

    @NotEmpty
    private String reflection;


    public Progress(UserProgressKey userProgressKey, String goal, int progressScore, String reflection) {
        this.userProgressKey = userProgressKey;
        this.goal = goal;
        this.progressScore = progressScore;
        this.reflection = reflection;
    }

}
