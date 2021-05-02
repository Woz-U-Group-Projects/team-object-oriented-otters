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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.plateit.project.models.Image;
import com.plateit.project.models.Restaurant;
import com.plateit.project.models.RestaurantAgent;
import com.plateit.project.models.RestaurantRepository;
import com.plateit.project.servicess.ImageService;
import com.plateit.project.models.RestaurantAgentRepository;


@RestController
@RequestMapping("api")
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	RestaurantAgentRepository restaurantAgentRepository;
	@Autowired
	ImageService imageService;
	
	@PostMapping("/restaurant")
	public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant){

		
		Restaurant newRestaurant = restaurantRepository.save(restaurant);
		
		return new ResponseEntity<>(newRestaurant, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<?> getRestaurant(@PathVariable String id){
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		
		if (restaurant != null) {
			return new ResponseEntity<>(restaurant, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/restaurant")
	public ResponseEntity<List<?>> getAllRestaurants(){
		List <Restaurant> restaurants = restaurantRepository.findAll();
		
		if (!restaurants.isEmpty()) {
			return new ResponseEntity<>(restaurants, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/restaurant")
	public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant){

		Restaurant restaurantToUpdate = restaurantRepository.findById(restaurant.id).orElse(null);

		if (restaurantToUpdate != null) {
			restaurantToUpdate = restaurant;
			restaurantRepository.save(restaurantToUpdate);
			return new ResponseEntity<>(restaurantToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
		
	@DeleteMapping("/restaurant/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable String id){
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		
		if (restaurant != null) {
			restaurantRepository.delete(restaurant);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/restaurant-picture")
	public ResponseEntity<?> uploadRestaturantPicture(@RequestPart("file") MultipartFile file){
		MultipartFile uploadedFile = file;
		Image uploadedImage = imageService.uploadFileService(uploadedFile);
		return new ResponseEntity<Image>(uploadedImage,HttpStatus.OK);
	}
	

}
