package com.example.PetStore.Services.UserService;

import com.example.PetStore.Models.Users.User;
import com.example.PetStore.Repositories.PetRepository;
import com.example.PetStore.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PetRepository petRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public List<User> createUsers() {
        List<String> firstNames = List.of("John", "Jane", "Alex", "Emily", "Chris", "Sara", "Mike", "Olivia", "Leo", "Emma");
        List<String> lastNames = List.of("Smith", "Johnson", "Brown", "Taylor", "Davis", "Clark", "Walker", "Allen", "Hill", "Lewis");
        List<String> emails = List.of("@yahoo.com", "@hotmail.com", "@gmail.com", "@live.com");
        List<User> users = new ArrayList<>();
        Random random = new Random();

        //petRepository.deleteAll();
        //userRepository.deleteAll();

        for(int i = 0; i < 10; i++) {
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            String lastName = lastNames.get(random.nextInt(lastNames.size()));
            String email = emails.get(random.nextInt(emails.size()));
            String fullEmail = (firstName + "." + lastName + email).toLowerCase();
            double budget = 1 + random.nextInt(15);
            users.add(new User(firstName, lastName, fullEmail, budget));
        }
        userRepository.saveAll(users);
        return userRepository.findAll();
    }
}
