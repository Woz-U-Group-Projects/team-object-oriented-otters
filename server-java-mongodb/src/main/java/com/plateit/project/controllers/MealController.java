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
import com.plateit.project.models.Meal;
import com.plateit.project.models.MealRepository;
import com.plateit.project.servicess.ImageService;

@RestController
@RequestMapping("api")
public class MealController {
	@Autowired
	MealRepository mealRepository;
	@Autowired
	ImageService imageService;
	
	@PostMapping("/meal")
	public ResponseEntity<?> createMeal(@RequestBody Meal meal){
		
		Meal newMeal = mealRepository.save(meal);
		
		if (newMeal != null)
			return new ResponseEntity<Meal>(newMeal, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/meal/{id}")
	public ResponseEntity<?> getMeal(@PathVariable String id){
		Meal meal = mealRepository.findById(id).orElse(null);
		
		if (meal != null) {
			return new ResponseEntity<>(meal, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/meal")
	public ResponseEntity<List<?>> getAllMeals(){
		List <Meal> meals = mealRepository.findAll();
		
		if (!meals.isEmpty()) {
			return new ResponseEntity<>(meals, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/meal")
	public ResponseEntity<?> updateMeal(@RequestBody Meal meal){

		Meal mealToUpdate = mealRepository.findById(meal.getId()).orElse(null);

		if (mealToUpdate != null) {
			mealToUpdate = meal;
			mealRepository.save(mealToUpdate);
			return new ResponseEntity<>(mealToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/meal/{id}")
	public ResponseEntity<?> deleteMeal(@PathVariable String id){
		Meal meal = mealRepository.findById(id).orElse(null);
		
		if (meal != null) {
			mealRepository.delete(meal);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/meal-picture")
	public ResponseEntity<?> uploadRestaturantPicture(@RequestPart("file") MultipartFile file){
		MultipartFile uploadedFile = file;
		Image uploadedImage = imageService.uploadFileService(uploadedFile);

		if (uploadedImage != null)
			return new ResponseEntity<Image>(uploadedImage,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
}
