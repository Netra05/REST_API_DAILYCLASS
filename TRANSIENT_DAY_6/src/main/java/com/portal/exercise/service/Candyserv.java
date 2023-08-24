package com.portal.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.Transientmodel;
import com.portal.exercise.repository.CandyRepo;

@Service
public class Candyserv {
	@Autowired
	public CandyRepo can;
	
	//post the data
	public String savecandy(Transientmodel t)
	{
		  can.save(t);
		  return "Data is saved to the database";
	}

	//get the data

	public List<Transientmodel>getcandy()
	{
		  return can.findAll();
	}

	//getUserByID
	public Optional<Transientmodel>getUserId(int userId)
	{
		  Optional<Transientmodel>candy=can.findById(userId);
		  if(candy.isPresent())
		  {
			  return candy;
		  }
		  return null;
	}
}
