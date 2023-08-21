package com.portal.exercise.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //to create table
@Table(name="petrolbunk") //if we no need of underscore in name
public class PetrolBunk 
{
	@Id //to say that its a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sapCode;
    @Column(name="bunkname")
	private String bunkName;
	private String adderss;
	public int getSapCode() {
		return sapCode;
	}
	public void setSapCode(int sapCode) {
		this.sapCode = sapCode;
	}
	public String getBunkName() {
		return bunkName;
	}
	public void setBunkName(String bunkName) {
		this.bunkName = bunkName;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	
	
	
	

}
