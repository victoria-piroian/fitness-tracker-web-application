package com.example.backend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class UserProgressKey implements Serializable {

    @Column(name = "clientId")
    Long clientId;

    private Long progressId;


    @Override
    public int hashCode() {
        String concatString = String.valueOf(clientId.hashCode()) + String.valueOf(progressId.hashCode());
        return concatString.hashCode();
    }
    public UserProgressKey(){}

    public UserProgressKey(Long clientId, Long progressId){
        this.setClientId(clientId);
        this.setProgressId(progressId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof UserProgressKey))
            return false;
        UserProgressKey other = (UserProgressKey) o;
        return clientId.equals(other.clientId) && progressId.equals(other.progressId);
    }

}
