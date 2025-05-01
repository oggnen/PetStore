package com.example.PetStore.Models.Pets;

import com.example.PetStore.Models.Users.User;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Pets")
public abstract class Pet {

    @Id
    @GeneratedValue
    private Long petId;
    private String name;
    private String description;
    private LocalDate dateOfBirth;

    @ManyToOne
    private User owner;
    public abstract double getPrice();

    public Pet() {

    }

    public Pet(String Name, String Description, LocalDate DateOfBirth) {
        this.name = Name;
        this.description = Description;
        this.dateOfBirth = DateOfBirth;
        this.owner = null;
    }

    public Long getPetId() {
        return this.petId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean hasOwner() {
        return this.owner != null;
    }

    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User Owner) {
        this.owner = Owner;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
}
