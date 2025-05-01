package com.example.PetStore.Models.Pets;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Cat extends Pet {

    public Cat() {

    }

    public Cat(String Name, String Description, LocalDate DateOfBirth) {
        super(Name, Description, DateOfBirth);
    }

    public double getPrice() {
        return (Period.between(this.getDateOfBirth(), LocalDate.now())).getYears();
    }
}
