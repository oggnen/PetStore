package com.example.PetStore.Controllers;

import com.example.PetStore.Models.Users.User;
import com.example.PetStore.Services.UserService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //REST endpoints
    @GetMapping("list-users")
    public List<User> listUsersREST() {
        return userService.listUsers();
    }

    @PostMapping("create-users")
    public List<User> createUsersREST() {
        return userService.createUsers();
    }

    //GraphQL queries
    @QueryMapping
    public List<User> createUsers() {
        return userService.createUsers();
    }

    @QueryMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }
}