package com.plateit.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.plateit.project.models.RestaurantAgent;
import com.plateit.project.models.RestaurantAgentRepository;
import com.plateit.project.models.RoleRepository;

@RestController
@RequestMapping("api")
public class RestaurantAgentController {
	
	@Autowired
	RestaurantAgentRepository restaurantAgentRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping("/restaurant-agent")
	public ResponseEntity<?> createRestaurantAgent(@RequestBody RestaurantAgent restaurantAgent){

		RestaurantAgent newRestaurantAgent = restaurantAgentRepository.save(restaurantAgent);
		
		return new ResponseEntity<>(newRestaurantAgent, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant-agent/{id}")
	public ResponseEntity<?> getRestaurantAgent(@PathVariable String id){
		RestaurantAgent restaurantAgent = restaurantAgentRepository.findById(id).orElse(null);
		
		if (restaurantAgent != null) {
			return new ResponseEntity<>(restaurantAgent, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/restaurant-agent")
	public ResponseEntity<List<?>> getAllRestaurantsAgents(){
		List <RestaurantAgent> restaurantAgents = restaurantAgentRepository.findAll();
		
		if (!restaurantAgents.isEmpty()) {
			return new ResponseEntity<>(restaurantAgents, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/restaurant-agent")
	public ResponseEntity<?> updateRestaurantAgent(@RequestBody RestaurantAgent restaurantAgent){
		RestaurantAgent restaurantAgentToUpdate = restaurantAgentRepository.findById(restaurantAgent.getId()).orElse(null);
		
		if (restaurantAgentToUpdate != null) {
			restaurantAgentRepository.save(restaurantAgentToUpdate);
			return new ResponseEntity<>(restaurantAgentToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/restaurant-agent/{id}")
	public ResponseEntity<?> deleteRestaurantAgent(@PathVariable String id){
		RestaurantAgent restaurantAgent = restaurantAgentRepository.findById(id).orElse(null);
		
		if (restaurantAgent != null) {
			return new ResponseEntity<>(restaurantAgent, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
