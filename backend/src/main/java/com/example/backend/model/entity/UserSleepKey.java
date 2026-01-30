package com.example.backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UserSleepKey implements Serializable {

    @Column(name = "clientId")
    Long clientId;

    private String dayYear;


    @Override
    public int hashCode() {
        String concatString = String.valueOf(clientId.hashCode()) + String.valueOf(dayYear.hashCode());
        return concatString.hashCode();
    }
    public UserSleepKey(){}

    public UserSleepKey(Long clientId, String dayYear){
        this.setClientId(clientId);
        this.setDayYear(dayYear);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof UserSleepKey))
            return false;
        UserSleepKey other = (UserSleepKey) o;
        return clientId.equals(other.clientId) && dayYear.equals(other.dayYear);
    }

}
