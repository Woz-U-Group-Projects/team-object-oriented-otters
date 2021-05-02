package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Menu {
	
	@Id
	private String id;
	private String name;
	private String description;
	private List<Item> items;
	
	public Menu() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
