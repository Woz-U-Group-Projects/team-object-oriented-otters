package com.plateit.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.plateit.project.models.Meal;
import com.plateit.project.models.MealRepository;

public class MealController {
	@Autowired
	MealRepository mealRepository;
	
	@PostMapping("/Meal")
	public Meal createMeal(@RequestBody Meal meal) {
		return mealRepository.save(meal);  
		
	}
}
