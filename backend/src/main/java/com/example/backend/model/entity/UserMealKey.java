package com.example.backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UserMealKey implements Serializable {

    @Column(name = "clientId")
    Long clientId;

    public String mealType;

    public String dayYear;


    @Override
    public int hashCode() {
        String concatString = String.valueOf(clientId.hashCode()) + String.valueOf(mealType.hashCode()) + String.valueOf(dayYear.hashCode());
        return concatString.hashCode();
    }
    public UserMealKey(){}

    public UserMealKey(Long clientId, String mealType, String dayYear){
        this.setClientId(clientId);
        this.setMealType(mealType);
        this.setDayYear(dayYear);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof UserMealKey))
            return false;
        UserMealKey other = (UserMealKey) o;
        return clientId.equals(other.clientId) && mealType.equals(other.mealType) && dayYear.equals(other.dayYear);
    }

}
