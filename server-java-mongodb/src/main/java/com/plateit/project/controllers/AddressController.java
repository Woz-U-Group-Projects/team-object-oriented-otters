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

import com.plateit.project.models.Address;
import com.plateit.project.models.AddressRepository;

@RestController
public class AddressController {

	@Autowired
	AddressRepository addressRepository;
	
	@PostMapping("/address")
	public ResponseEntity<?> createAddress(@RequestBody Address address){
		Address newAddress = addressRepository.save(address);
		return new ResponseEntity<>(newAddress, HttpStatus.OK);
	}
	
	@GetMapping("/address/{id}")
	public ResponseEntity<?> getAddress(@PathVariable String id){
		Address address = addressRepository.findById(id).orElse(null);
		
		if (address != null) {
			return new ResponseEntity<>(address, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddresses(){
		List <Address> addresses = addressRepository.findAll();
		
		if (!addresses.isEmpty()) {
			return new ResponseEntity<>(addresses, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/address/")
	public ResponseEntity<?> updateAddress(@RequestBody Address address){
		Address addressToUpdate = addressRepository.findById(address.id).orElse(null);
		
		if (addressToUpdate != null) {
			addressRepository.save(addressToUpdate);
			return new ResponseEntity<>(addressToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/address/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable String id){
		Address address = addressRepository.findById(id).orElse(null);
		
		if (address != null) {
			addressRepository.delete(address);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
