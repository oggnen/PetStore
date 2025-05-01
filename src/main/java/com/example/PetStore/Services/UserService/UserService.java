package com.example.PetStore.Services.UserService;

import com.example.PetStore.Models.Users.User;
import java.util.List;

public interface UserService {
    List<User> listUsers();
    List<User> createUsers();
}