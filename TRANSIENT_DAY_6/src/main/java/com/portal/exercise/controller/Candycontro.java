package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.portal.exercise.model.Transientmodel;
import com.portal.exercise.service.Candyserv;

@RestController
public class Candycontro {
	@Autowired
	public Candyserv canserve;
	
	//post mapping
	   @PostMapping("/postCandy")
	   public String postCandy(@RequestBody Transientmodel tm)
	   {
	   	canserve.savecandy(tm);
	   	return "data saved";
	   }
	   
	   
	   //get mapping
	   @GetMapping("/getCandy")
	   	public List<Transientmodel>getCandyInfo()
	   	{
	   	return canserve.getcandy();
	   	}
	   
	   //getUserByID
	   @GetMapping("/users/{userId}")
	   public ResponseEntity<?> getUserById(@PathVariable int userId){
	   	Optional<Transientmodel>candy=canserve.getUserId(userId);
	   	
	   	if(candy!=null)
	   	{
	   		return ResponseEntity.ok(candy); //Return the user's data if available
	   	}
	   	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
	   }
	   

}
