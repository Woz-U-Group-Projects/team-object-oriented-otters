package com.plateit.project.models;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

public class OperatingDayTime {
	
	@Id
	public String id;
	public String day;
	public String openHour;
	public String closeHour;
	
	public OperatingDayTime () {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOpenHour() {
		return openHour;
	}

	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}

	public String getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(String closeHour) {
		this.closeHour = closeHour;
	}
	
	

}
