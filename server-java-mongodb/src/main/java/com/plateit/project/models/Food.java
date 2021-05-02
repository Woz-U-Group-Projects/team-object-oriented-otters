package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Food implements Item{

	@Id
	private String id;
	private Image picture;
	private String name;
	private String description;
	private UnitType unitType;
	private List <String> ingredients;
	private float price;
	
	public Food() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Image getPicture() {
		return picture;
	}
	public void setPicture(Image picture) {
		this.picture = picture;
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
	public UnitType getUnitType() {
		return unitType;
	}
	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
