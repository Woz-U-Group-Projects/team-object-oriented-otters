package com.plateit.project.models;

public interface Item {

	public String getId();
	public void setId(String id);
	public Image getPicture();
	public void setPicture(Image picture);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
	public UnitType getUnitType();
	public void setUnitType(UnitType unitType);
	public float getPrice();
	public void setPrice(float price);
	 
	 
}
