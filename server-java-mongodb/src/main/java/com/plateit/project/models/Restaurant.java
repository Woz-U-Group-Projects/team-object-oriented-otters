package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.lang.Nullable;



public class Restaurant {

	@Id
	public String id;
	public Image picture;
	public String name;
	public Address address;
	public List <OperatingDayTime> operatingDaysTimes;
	public String phoneNumber;
	public String website;
	@DBRef
	@Nullable
	private List <RestaurantAgent> restaurantAgents;
	
	public Restaurant() {
		
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OperatingDayTime> getOperatingDaysTimes() {
		return operatingDaysTimes;
	}

	public void setOperatingDaysTimes(List<OperatingDayTime> operatingDaysTimes) {
		this.operatingDaysTimes = operatingDaysTimes;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<RestaurantAgent> getRestaurantAgents() {
		return restaurantAgents;
	}

	public void setRestaurantAgents(List<RestaurantAgent> restaurantAgents) {
		this.restaurantAgents = restaurantAgents;
	}
	
	
}
