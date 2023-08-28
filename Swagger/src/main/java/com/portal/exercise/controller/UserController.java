package com.portal.exercise.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.Users;
import com.portal.exercise.repository.UsersRepo;



@RestController
public class UserController {
	@Autowired
	public UsersRepo urepo;
	
	//post mapping
    @PostMapping("/postUser")
    public String postuser(@RequestBody Users us)
    {
    	urepo.save(us);
    	return "data saved";
    }
    
    //get mapping
    @GetMapping("/getUser")
    	public List<Users>getUserInfo()
    	{
    	return urepo.findAll();
    	}
    
}
