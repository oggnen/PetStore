package com.example.PetStore.Controllers;

import com.example.PetStore.Models.Pets.*;
import com.example.PetStore.Services.PetService.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetServiceImpl petService;

    //REST endpoints
    @GetMapping("list-pets")
    public List<Pet> listPetsREST() {
        return petService.listPets();
    }

    @GetMapping("history-log")
    public List<String> historyLog() throws IOException {
        return Files.readAllLines(Paths.get("logs/app.log"));
    }

    @PostMapping("create-pets")
    public List<Pet> createPetsREST() {
        return petService.createPets();
    }

    @PostMapping("buy")
    public List<Pet> buy() {
        return petService.buy();
    }

    //GraphQL queries
    @QueryMapping
    public List<Pet> createPets() {
        return petService.createPets();
    }

    @QueryMapping
    public List<Pet> listPets() {
        return petService.listPets();
    }
}
