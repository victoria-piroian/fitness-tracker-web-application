package com.example.backend.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "UserProfile")
public class User {
    @Id
    private Long clientId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Max(150)
    @Min(0)
    private int age;

    @Max(300)
    @Min(0)
    private float height;

    @Max(800)
    @Min(0)
    private float weight;

    @NotEmpty
    private String password;

    public User(Long clientId, String firstName, String lastName, int age, float height, float weight, String password){
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.password = password;
    }


}
