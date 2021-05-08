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



import com.plateit.project.models.ShoppingCart;
import com.plateit.project.models.ShoppingCartRepository;

@RestController
@RequestMapping("api")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@PostMapping("/shopping-cart")
	public ResponseEntity<?> createChoppingCart(@RequestBody ShoppingCart shoppingCart){
		
		ShoppingCart newShoppingCart = shoppingCartRepository.save(shoppingCart);
		
		if (newShoppingCart != null)
			return new ResponseEntity<ShoppingCart>(newShoppingCart, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/shopping-cart/{id}")
	public ResponseEntity<?> getShoppingCart(@PathVariable String id){
		ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElse(null);
		
		if (shoppingCart != null) {
			return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/shopping-cart")
	public ResponseEntity<List<?>> getAllShoppingCarts(){
		List <ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
		
		if (!shoppingCarts.isEmpty()) {
			return new ResponseEntity<>(shoppingCarts, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/shopping-cart")
	public ResponseEntity<?> updateShoppingCart(@RequestBody ShoppingCart shoppingCart){

		ShoppingCart shoppingCartToUpdate = shoppingCartRepository.findById(shoppingCart.getId()).orElse(null);

		if (shoppingCartToUpdate != null) {
			shoppingCartToUpdate = shoppingCart;
			shoppingCartRepository.save(shoppingCartToUpdate);
			return new ResponseEntity<>(shoppingCartToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/shopping-cart/{id}")
	public ResponseEntity<?> deleteShoppingCart(@PathVariable String id){
		ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElse(null);
		
		if (shoppingCart != null) {
			shoppingCartRepository.delete(shoppingCart);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
