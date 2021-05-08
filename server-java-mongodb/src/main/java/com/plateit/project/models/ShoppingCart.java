package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class ShoppingCart {
	
	@Id
	private String id;
	private List<Item> items;
	private Customer customer;
	private ShoppingCartStatus shoppingCartStatus;
	
	public ShoppingCart() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShoppingCartStatus getShoppingCartStatus() {
		return shoppingCartStatus;
	}

	public void setShoppingCartStatus(ShoppingCartStatus shoppingCartStatus) {
		this.shoppingCartStatus = shoppingCartStatus;
	}
	
	
	
	

}
