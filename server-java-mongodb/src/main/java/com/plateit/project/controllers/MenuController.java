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



import com.plateit.project.models.Menu;
import com.plateit.project.models.MenuRepository;

@RestController
@RequestMapping("api")
public class MenuController {
	
	@Autowired
	MenuRepository menuRepository;
	
	@PostMapping("/menu")
	public ResponseEntity<?> createMenu(@RequestBody Menu menu){
		
		Menu newMenu = menuRepository.save(menu);
		
		if (newMenu != null)
			return new ResponseEntity<Menu>(newMenu, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/meu/{id}")
	public ResponseEntity<?> getMenu(@PathVariable String id){
		Menu menu = menuRepository.findById(id).orElse(null);
		
		if (menu != null) {
			return new ResponseEntity<>(menu, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<?>> getAllMenus(){
		List <Menu> menus = menuRepository.findAll();
		
		if (!menus.isEmpty()) {
			return new ResponseEntity<>(menus, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/menu")
	public ResponseEntity<?> updateMenu(@RequestBody Menu menu){

		Menu menuToUpdate = menuRepository.findById(menu.getId()).orElse(null);

		if (menuToUpdate != null) {
			menuToUpdate = menu;
			menuRepository.save(menuToUpdate);
			return new ResponseEntity<>(menuToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/menu/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable String id){
		Menu menu = menuRepository.findById(id).orElse(null);
		
		if (menu != null) {
			menuRepository.delete(menu);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
