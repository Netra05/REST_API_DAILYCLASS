package com.portal.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.exercise.model.Users;

public interface UsersRepo extends JpaRepository<Users,Integer>{

}

