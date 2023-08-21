package com.portal.exercise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.PetrolBunk;
import com.portal.exercise.repository.FuelRepo;

@Service

public class FuelService {
	@Autowired
  public FuelRepo frepo;
	
	//post the data
	public PetrolBunk saveDetails(PetrolBunk p)
	{
		return frepo.save(p);
	}
	
	//get the data
	public List<PetrolBunk> getDetails()
	{
		return frepo.findAll(); //to get all the data
	}
}
