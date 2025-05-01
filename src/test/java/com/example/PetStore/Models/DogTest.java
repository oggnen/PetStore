package com.example.PetStore.Models;

import com.example.PetStore.Models.Pets.Dog;
import com.example.PetStore.Models.Users.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void testDogPriceWithRating() {
        LocalDate dateOfBirth = LocalDate.now().minusYears(5);
        Dog dog = new Dog("Rex", "Loyal dog", dateOfBirth, 3);
        assertEquals(8, dog.getPrice());
    }

    @Test
    void testDogPriceWithZeroRating() {
        LocalDate dateOfBirth = LocalDate.now().minusYears(5);
        Dog dog = new Dog("Rex", "Loyal dog", dateOfBirth, 0);
        assertEquals(5, dog.getPrice());
    }

    @Test
    void testDogOwnerAssignment() {
        Dog dog = new Dog("Max", "Energetic", LocalDate.now().minusYears(2), 2);
        User owner = new User("Bob", "Jones", "bob@example.com", 80.0);
        dog.setOwner(owner);
        assertEquals("Bob", dog.getOwner().getFirstName());
    }
}