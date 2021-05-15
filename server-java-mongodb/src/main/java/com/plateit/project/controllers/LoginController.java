package com.plateit.project.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.plateit.project.models.Login;
import com.plateit.project.models.LoginRepository;
import com.plateit.project.servicess.LoginDetailsService;

@RestController

public class LoginController {

	@Autowired
	private LoginRepository userRepository;
		
	@Autowired
	private LoginDetailsService userService;
		
	@PostMapping("/api/register")
	public ResponseEntity<?> createUser(@RequestBody Login user) {
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		Login foundUser = userRepository.findByUsername(user.getUsername());
		if (foundUser == null) {
			Login newUser = user;
			userService.Save(newUser);
			return new ResponseEntity<Login>(newUser, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.FOUND);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login user){
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		Login foundUser = userRepository.findByUsername(user.getUsername());
		
		if (foundUser != null) {
			userService.loadUserByUsername(foundUser.getUsername());
			return new ResponseEntity<Login>(foundUser, HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/error")
	public ResponseEntity<?> login(@RequestBody Object error){
		System.out.println("Message: "+error.toString());
		//System.out.println("password: "+error.toString());
		
		return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
		
	}

}
