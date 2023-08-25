package com.portal.exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coco")
public class ChocolateModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ChocoId;
	private String ChocoName;
	private String Brand;
	private int Quantity;
	public int getChocoId() {
		return ChocoId;
	}
	public void setChocoId(int chocoId) {
		ChocoId = chocoId;
	}
	public String getChocoName() {
		return ChocoName;
	}
	public void setChocoName(String chocoName) {
		ChocoName = chocoName;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
