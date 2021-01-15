package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Pet;
import com.revature.models.User;
import com.revature.remote.FeignUserService;

@RestController
@RequestMapping("/pets")
public class PetController {

	private Pet thePet = new Pet("Tep", 1, null);
	
	@Autowired//field injection, this is bad because it makes things very hard to test
	private FeignUserService fus;
	
	@GetMapping
	public Pet getAllPets() {
		//User owner = new RestTemplate().getForEntity("http://localhost:8765/users", User.class).getBody();
		User owner = fus.getAllUser();
		this.thePet.setOwner(owner);
		return this.thePet;
	}
	
	
}
