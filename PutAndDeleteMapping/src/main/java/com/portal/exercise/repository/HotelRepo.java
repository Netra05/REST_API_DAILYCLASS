package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.HotelModel;

public interface HotelRepo extends JpaRepository<HotelModel, Integer> {
	

}
