package com.plateit.project.models;

import java.time.LocalTime;

import org.springframework.data.annotation.Id;

public class OperatingDayTime {
	
	@Id
	public String id;
	public String day;
	public LocalTime openHour;
	public LocalTime closeHour;
	
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

	public LocalTime getOpenHour() {
		return openHour;
	}

	public void setOpenHour(LocalTime openHour) {
		this.openHour = openHour;
	}

	public LocalTime getCloseHour() {
		return closeHour;
	}

	public void setCloseHour(LocalTime closeHour) {
		this.closeHour = closeHour;
	}
	
	

}
