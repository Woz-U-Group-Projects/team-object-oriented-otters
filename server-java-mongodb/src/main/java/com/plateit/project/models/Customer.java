package com.plateit.project.models;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Customer {
	
	@Id
	private String id;
	private Image pictureProfile;
	private String firstName;
	private String lastName;
	private List <CustomerAddress> address;
	private String email;
	private String phoneNumber;
	
	public Customer() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CustomerAddress> getAddress() {
		return address;
	}

	public void setAddress(List<CustomerAddress> address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Image getPictureProfile() {
		return pictureProfile;
	}

	public void setPictureProfile(Image pictureProfile) {
		this.pictureProfile = pictureProfile;
	}
	
	

}
