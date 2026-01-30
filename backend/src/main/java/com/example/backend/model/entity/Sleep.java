package com.example.backend.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Sleep")
public class Sleep {

    @EmbeddedId
    UserSleepKey userSleepKey;

    private float duration;

    @Max(5)
    @Min(0)
    private int restScore;


    private boolean dream;

    private boolean alarmWakeUp;

    @Max(100)
    @Min(0)
    private int numNaps;


    public Sleep(UserSleepKey userSleepKey, float duration, int restScore, boolean dream, boolean alarmWakeUp, int numNaps) {
        this.userSleepKey = userSleepKey;
        this.duration = duration;
        this.restScore = restScore;
        this.dream = dream;
        this.alarmWakeUp = alarmWakeUp;
        this.numNaps = numNaps;
    }

    public boolean getDream() {
        return dream;
    }

    public boolean getAlarmWakeUp() {
        return alarmWakeUp;
    }
}
