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

import com.plateit.project.models.Role;
import com.plateit.project.models.RoleRepository;

@RestController
@RequestMapping("api")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping("/role")
	public ResponseEntity<?> createRole(@RequestBody Role role){
		Role newRole = roleRepository.save(role);
		
		return new ResponseEntity<>(newRole, HttpStatus.OK);
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<?> getRole(@PathVariable String id){
		Role role = roleRepository.findById(id).orElse(null);
		
		if (role != null) {
			return new ResponseEntity<>(role, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/role")
	public ResponseEntity<List<?>> getAllRoles(){
		List roles = roleRepository.findAll();
		
		if (!roles.isEmpty()) {
			return new ResponseEntity<>(roles, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/role")
	public ResponseEntity<?> updateRole(@RequestBody Role role){
		Role roleToUpdate = roleRepository.findById(role.id).orElse(null);
		
		if (roleToUpdate != null) {
			roleRepository.save(roleToUpdate);
			return new ResponseEntity<>(roleToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable String id){
		Role role = roleRepository.findById(id).orElse(null);
		
		if (role != null) {
			roleRepository.delete(role);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
