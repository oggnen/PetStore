package com.example.PetStore;

import com.example.PetStore.Models.Pets.Pet;
import com.example.PetStore.Models.Users.User;
import com.example.PetStore.Repositories.PetRepository;
import com.example.PetStore.Repositories.UserRepository;
import com.example.PetStore.Services.PetService.PetService;
import com.example.PetStore.Services.UserService.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PetStoreApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PetRepository petRepository;
	@Autowired
	private PetService petService;
	@Autowired
	private UserService userService;

	@Test
	void testCreateUsers() {
		userService.createUsers();
		List<User> users = userService.listUsers();
		assertEquals(10, users.size());
	}

	@Test
	void testCreatePets() {
		petService.createPets();
		List<Pet> pets = petService.listPets();
		assertEquals(20, pets.size());
	}

	@Test
	void testListUsers() {
		userService.createUsers();
		List<User> users = userService.listUsers();
		assertEquals(userRepository.findAll().size(), users.size());
	}

	@Test
	void testListPets() {
		petService.createPets();
		List<Pet> pets = petService.listPets();
		assertEquals(petRepository.findAll().size(), pets.size());
	}

	@Test
	void testBuyPetsAssignsOwner() {
		userService.createUsers();
		petService.createPets();
		petService.buy();

		long ownedCount = petService.listPets().stream().filter(Pet::hasOwner).count();
		assertTrue(ownedCount > 0, "Some pets should have owners after buying");
	}
}
