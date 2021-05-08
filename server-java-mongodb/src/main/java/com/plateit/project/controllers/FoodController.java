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
import com.plateit.project.servicess.ImageService;
import com.plateit.project.models.Food;
import com.plateit.project.models.FoodRepository;

@RestController
@RequestMapping("api")
public class FoodController {

	@Autowired
	FoodRepository foodRepository;
	@Autowired
	ImageService imageService;
	
	@PostMapping("/food")
	public ResponseEntity<?> createFood(@RequestBody Food food){
		
		Food newFood = foodRepository.save(food);
		
		if (newFood != null)
			return new ResponseEntity<Food>(newFood, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/food/{id}")
	public ResponseEntity<?> getFood(@PathVariable String id){
		Food food = foodRepository.findById(id).orElse(null);
		
		if (food != null) {
			return new ResponseEntity<>(food, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/food")
	public ResponseEntity<List<?>> getAllFoods(){
		List <Food> foods = foodRepository.findAll();
		
		if (!foods.isEmpty()) {
			return new ResponseEntity<>(foods, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/food")
	public ResponseEntity<?> updateFood(@RequestBody Food food){

		Food foodToUpdate = foodRepository.findById(food.getId()).orElse(null);

		if (foodToUpdate != null) {
			foodToUpdate = food;
			foodRepository.save(foodToUpdate);
			return new ResponseEntity<>(foodToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/food/{id}")
	public ResponseEntity<?> deleteFood(@PathVariable String id){
		Food food = foodRepository.findById(id).orElse(null);
		
		if (food != null) {
			foodRepository.delete(food);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/food-picture")
	public ResponseEntity<?> uploadRestaturantPicture(@RequestPart("file") MultipartFile file){
		MultipartFile uploadedFile = file;
		Image uploadedImage = imageService.uploadFileService(uploadedFile);

		if (uploadedImage != null)
			return new ResponseEntity<Image>(uploadedImage,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
}
