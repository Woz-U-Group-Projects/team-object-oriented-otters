package com.plateit.app.models;

import org.springframework.data.annotation.Id;



public class UnitType {
	
	@Id
	public String id;
	public String name;
	public String description;
	
	public UnitType() {
		
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
	

}
