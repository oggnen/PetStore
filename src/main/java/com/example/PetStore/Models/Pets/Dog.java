package com.example.PetStore.Models.Pets;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Dog extends Pet {

    private Integer rating;

    public Dog() {

    }


    public Dog(String Name, String Description, LocalDate DateOfBirth, Integer Rating) {
        super(Name, Description, DateOfBirth);
        this.rating = Rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return (Period.between(this.getDateOfBirth(), LocalDate.now())).getYears() + rating;
    }
}
