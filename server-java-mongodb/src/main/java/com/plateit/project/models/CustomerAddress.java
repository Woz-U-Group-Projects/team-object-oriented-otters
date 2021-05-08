package com.plateit.project.models;

public class CustomerAddress extends Address{

	private AddressType addressType;
	
	public CustomerAddress() {
		super();
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
	
}
