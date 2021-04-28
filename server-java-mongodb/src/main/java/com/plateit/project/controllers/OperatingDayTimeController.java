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

import com.plateit.project.models.OperatingDayTime;
import com.plateit.project.models.OperatingDayTimeRepository;


@RestController
public class OperatingDayTimeController {
	
	@Autowired
	OperatingDayTimeRepository operatingDayTimeRepository;
	
	@PostMapping("/operatingdaytime")
	public ResponseEntity<OperatingDayTime> createOperationgDayTime(@RequestBody OperatingDayTime operatingDayTime) {
		
		return new ResponseEntity<>(operatingDayTimeRepository.save(operatingDayTime), HttpStatus.OK);
	}
	
	@GetMapping("/operatingdaytime/{id}")
	public ResponseEntity <?>getOperatingDayTime(@PathVariable String id) {
		
		OperatingDayTime operatingDayTime = operatingDayTimeRepository.findById(id).orElse(null);
		if (operatingDayTime != null) {
			return new ResponseEntity<>(operatingDayTime, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/operatingdaytime")
	public ResponseEntity<?> getAllOperationDaysTimes(){
		List <OperatingDayTime> operatingDaysTimes = operatingDayTimeRepository.findAll();
		
		if (!operatingDaysTimes.isEmpty()) {
			return new ResponseEntity<>(operatingDaysTimes, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/operatingdaytime")
	public ResponseEntity<?> updateOperatingDayTime(@RequestBody OperatingDayTime operatingDayTime){
		
		OperatingDayTime operatingDayTimeToUpdate = operatingDayTimeRepository.findById(operatingDayTime.id).orElse(null);
		
		if (operatingDayTimeToUpdate != null) {
			operatingDayTimeRepository.save(operatingDayTimeToUpdate);
			return new ResponseEntity<>(operatingDayTime, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/operatingdaytime/{id}")
	public ResponseEntity<?> deleteOperatingDayTime(@PathVariable String id){
		OperatingDayTime operatingDayTime = operatingDayTimeRepository.findById(id).orElse(null);
		
		if (operatingDayTime != null) {
			operatingDayTimeRepository.delete(operatingDayTime);
			return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("{'message':'No content recieved'}", HttpStatus.BAD_REQUEST);
		}
	}

}
