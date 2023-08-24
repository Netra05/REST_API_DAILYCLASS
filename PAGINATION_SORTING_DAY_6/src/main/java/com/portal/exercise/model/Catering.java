package com.portal.exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food")
public class Catering {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CateringId;
	private String hotelName;
	private String city;
	public int getCateringId() {
		return CateringId;
	}
	public void setCateringId(int cateringId) {
		CateringId = cateringId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
