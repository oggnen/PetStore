package com.example.PetStore.Services.PetService;

import com.example.PetStore.Models.Pets.Pet;
import java.util.List;

public interface PetService {
    List<Pet> listPets();
    List<Pet> createPets();
    List<Pet> buy();
    //List<Dog> listDogs();
}
