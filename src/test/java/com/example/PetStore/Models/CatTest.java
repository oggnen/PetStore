package com.example.PetStore.Models;

import com.example.PetStore.Models.Pets.Cat;
import com.example.PetStore.Models.Pets.Dog;
import com.example.PetStore.Models.Users.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    @Test
    void testCatPriceCalculation() {
        LocalDate dateOfBirth = LocalDate.now().minusYears(4);
        Cat cat = new Cat("Mittens", "A fluffy cat", dateOfBirth);
        assertEquals(4, cat.getPrice());
    }

    @Test
    void testDogOwnerAssignment() {
        Cat cat = new Cat("Herman", "Energetic", LocalDate.now().minusYears(2));
        User owner = new User("Bob", "Jones", "bob@example.com", 20.0);
        cat.setOwner(owner);
        assertEquals("Bob", cat.getOwner().getFirstName());
    }
}