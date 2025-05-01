package com.example.PetStore.Models.Users;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Double budget;

    public User() {

    }

    public User(String firstName, String lastName, String email, Double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }

    public Double getBudget() {
        return this.budget;
    }

    public void setBudget(Double Budget) {
        this.budget = Budget;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }
}