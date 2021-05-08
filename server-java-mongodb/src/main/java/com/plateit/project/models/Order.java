package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Order {

	@Id
	private String id;
	private String orderNumber;
	private Customer customer;
	private paymentMethod paymentMethod;
	private List<Item> items;
	private float subtotal;
	private float tax;
	private float total;
	
	public Order() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public paymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(paymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
}
