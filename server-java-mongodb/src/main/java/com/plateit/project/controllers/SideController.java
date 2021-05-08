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

import com.plateit.project.models.SideRepository;
import com.plateit.project.models.Side;
import com.plateit.project.models.Image;
import com.plateit.project.servicess.ImageService;

@RestController
@RequestMapping("api")
public class SideController {

	@Autowired
	SideRepository sideRepository;
	@Autowired
	ImageService imageService;
	
	@PostMapping("/side")
	public ResponseEntity<?> createSide(@RequestBody Side side){
		Side newSide = sideRepository.save(side);
		
		if (newSide != null)
			return new ResponseEntity<Side>(side, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("/side/{id}")
	public ResponseEntity<?> getSide(@PathVariable String id){
		Side side = sideRepository.findById(id).orElse(null);
		
		if (side != null) {
			return new ResponseEntity<>(side, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/side")
	public ResponseEntity<List<?>> getAllSides(){
		List <Side> sides = sideRepository.findAll();
		
		if (!sides.isEmpty()) {
			return new ResponseEntity<>(sides, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/side")
	public ResponseEntity<?> updateSide(@RequestBody Side side){

		Side sideToUpdate = sideRepository.findById(side.id).orElse(null);

		if (sideToUpdate != null) {
			sideToUpdate = side;
			sideRepository.save(sideToUpdate);
			return new ResponseEntity<>(sideToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/side/{id}")
	public ResponseEntity<?> deleteSide(@PathVariable String id){
		Side side = sideRepository.findById(id).orElse(null);
		
		if (side != null) {
			sideRepository.delete(side);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/side-picture")
	public ResponseEntity<?> uploadRestaturantPicture(@RequestPart("file") MultipartFile file){
		MultipartFile uploadedFile = file;
		Image uploadedImage = imageService.uploadFileService(uploadedFile);
		
		if (uploadedImage != null)
			return new ResponseEntity<Image>(uploadedImage,HttpStatus.OK);
		else
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}
	
}
