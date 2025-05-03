package com.example.PetStore.Services.PetService;

import com.example.PetStore.Models.Pets.*;
import com.example.PetStore.Models.Users.User;
import com.example.PetStore.Repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

    public List<Pet> listPets() {
        return petRepository.findAll();
    }

    public List<Pet> createPets() {
        List<String> petNames = List.of("Max", "Bella", "Charlie", "Luna", "Lucy", "Rocky", "Milo", "Coco", "Ruby", "Leo");
        List<String> petDescriptions = List.of( "Loves to cuddle", "Energetic and playful", "Very loyal", "Sleeps all day", "Food-driven", "Great with kids");
        Random random = new Random();
        List<Pet> pets = new ArrayList<>();
        //petRepository.deleteAll();

        //FOR TESTING - pet with price 1 which will always be bought
        pets.add(new Cat("Max", "Loves to cuddle", LocalDate.of(2024,1,1)));

        for(int i = 0; i < 19; i++) {
            String petName = petNames.get(random.nextInt(petNames.size()));
            String petDescription = petDescriptions.get(random.nextInt(petDescriptions.size()));
            LocalDate start = LocalDate.of(2015, 1, 1);
            LocalDate end = LocalDate.of(2023, 12, 31);
            LocalDate dateOfBirth = getRandomDateBetween(start, end);

            if(random.nextBoolean()) {
                pets.add(new Cat(petName, petDescription, dateOfBirth));
            }
            else {
                pets.add(new Dog(petName, petDescription, dateOfBirth, random.nextInt(10)));
            }
        }
        petRepository.saveAll(pets);
        return petRepository.findAll();
    }

    private static LocalDate getRandomDateBetween(LocalDate start, LocalDate end) {
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);

        return LocalDate.ofEpochDay(randomDay);
    }

    public List<Pet> buy() {
        List<User> users = userRepository.findAll();
        List<Pet> pets = petRepository.findAll();
        int noUsersWhoBoughtAPet = 0, noUsersWhoDidntBuyAPet = 0;

        for(User user: users) {
            boolean userBoughtAPet = false;

            for(Pet pet: pets) {
                if(pet.getOwner() == null && user.getBudget() >= pet.getPrice()) {
                        pet.setOwner(user);
                        petRepository.save(pet);
                        user.setBudget(user.getBudget() - pet.getPrice());
                        userBoughtAPet = true;
                        pets.remove(pet);
                        if(pet instanceof Dog) {
                            System.out.println("Woof, dog " + pet.getName() + " has owner " + user.getFirstName() + " " + user.getLastName());
                        }
                        else {
                            System.out.println("Meow, cat " + pet.getName() + " has owner " + user.getFirstName() + " " + user.getLastName());
                        }
                        break;
                }
            }

            if(userBoughtAPet) {
                noUsersWhoBoughtAPet++;
            }
            else {
                noUsersWhoDidntBuyAPet++;
            }
        }
        logger.info("Number of users who bought a pet: {} " +
                "Number of users who weren't allowed buy a pet: {}", noUsersWhoBoughtAPet, noUsersWhoDidntBuyAPet);
        return petRepository.findAll();
    }
}
