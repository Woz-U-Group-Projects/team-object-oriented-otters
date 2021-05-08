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

import com.plateit.project.models.Order;
import com.plateit.project.models.OrderRepository;

@RestController
@RequestMapping("api")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody Order order){
		
		Order newOrder = orderRepository.save(order);
		
		if (newOrder != null)
			return new ResponseEntity<Order>(newOrder, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrder(@PathVariable String id){
		Order order = orderRepository.findById(id).orElse(null);
		
		if (order != null) {
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/order")
	public ResponseEntity<List<?>> getAllOrders(){
		List <Order> orders = orderRepository.findAll();
		
		if (!orders.isEmpty()) {
			return new ResponseEntity<>(orders, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/order")
	public ResponseEntity<?> updateOrder(@RequestBody Order order){

		Order orderToUpdate = orderRepository.findById(order.getId()).orElse(null);

		if (orderToUpdate != null) {
			orderToUpdate = order;
			orderRepository.save(orderToUpdate);
			return new ResponseEntity<>(orderToUpdate, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable String id){
		Order order = orderRepository.findById(id).orElse(null);
		
		if (order != null) {
			orderRepository.delete(order);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
