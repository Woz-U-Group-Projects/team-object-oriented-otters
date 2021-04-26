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

import com.plateit.project.models.UnitType;
import com.plateit.project.models.UnitTypeRepository;

@RestController
public class UnitTypeController {
	

	@Autowired
	UnitTypeRepository unitTypeRepository;
	
	
	@PostMapping("/unit-type")
	public UnitType createUnitType(@RequestBody UnitType unitType) {
		return unitTypeRepository.save(unitType);
	}
	
}
