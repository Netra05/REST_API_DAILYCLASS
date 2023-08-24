package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Catering;

public interface CateringRepo extends JpaRepository<Catering,Integer> {

}
