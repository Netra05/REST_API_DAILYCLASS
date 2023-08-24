package com.portal.exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="candies")
public class Transientmodel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CandyId;
	private String candyName;
	private String brand;
	@Transient
	private int quantity;
	
	public int getCandyId() {
		return CandyId;
	}
	public void setCandyId(int candyId) {
		CandyId = candyId;
	}
	public String getCandyName() {
		return candyName;
	}
	public void setCandyName(String candyName) {
		this.candyName = candyName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
