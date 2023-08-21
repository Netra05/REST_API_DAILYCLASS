package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.PetrolBunk;

public interface FuelRepo extends JpaRepository<PetrolBunk,Integer>{
	

}
