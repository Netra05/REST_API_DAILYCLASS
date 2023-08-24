package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Transientmodel;

public interface CandyRepo extends JpaRepository< Transientmodel,Integer>{

}
