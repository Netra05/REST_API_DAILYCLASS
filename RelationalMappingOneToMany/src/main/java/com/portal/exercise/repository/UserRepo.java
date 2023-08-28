package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer>{

}
