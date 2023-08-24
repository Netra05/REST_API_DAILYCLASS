package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.Catering;
import com.portal.exercise.service.CateringServ;

@RestController
public class CateringControl {
	@Autowired
   public CateringServ cserv;
   
   
 //post mapping
   @PostMapping("/postCater")
   public String postHotel(@RequestBody Catering cr)
   {
   	cserv.saveCater(cr);
   	return "data saved";
   }
   
   //get mapping
   @GetMapping("/getCater")
   	public List<Catering>getCaterInfo()
   	{
   	return cserv.getCatering();
   	}
   
   //getUserByID
   @GetMapping("/users/{userId}")
   public ResponseEntity<?> getUserById(@PathVariable int userId){
   	Optional<Catering>cater=cserv.getUserId(userId);
   	
   	if(cater!=null)
   	{
   		return ResponseEntity.ok(cater); //Return the user's data if available
   	}
   	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
   }
   
   //put mapping
   @PutMapping("/updateCater")
   public Catering updateHotelInfo(@RequestBody Catering ca)
   {
   	return cserv.updateCatering(ca);
   }
   @PutMapping("/updateCaterif/{id}")
   public ResponseEntity<String> updateHotelInfor(@PathVariable int id,@RequestBody Catering ca){
   	   boolean updated=cserv.updateCateringif(id,ca);
			   if(updated)
			   {
				  return ResponseEntity.ok("Hotel with ID "+id+" updated successfully"); //.ok means sucess
			   }
			   else
			   {
				  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found and not updated");
			   }
	   }
   
   @GetMapping("/sortAsc/{name}")
   public List<Catering>sortasc(@PathVariable("name") String hotelName)
   {
	   return cserv.sortByAsc(hotelName);
   }
   
   //Pagination
   
   @GetMapping("/pagination/{num}/{size}")
   public List<Catering>paginationEx(@PathVariable("num")int num,@PathVariable("size")int size)
   {
	   return cserv.pagination(num, size);
   }
   
   //pagination and sorting
   @GetMapping("/paginationAndSort/{num}/{size}/{name}")
   public List<Catering>paginationEx1(@PathVariable("num")int num,@PathVariable("size")int size,@PathVariable("name") String hotelName)
   {
	   return cserv.paginationAndSorting(num, size,hotelName);
   }
   
   
   
}
