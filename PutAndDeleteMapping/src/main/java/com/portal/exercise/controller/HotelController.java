package com.portal.exercise.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.HotelModel;
import com.portal.exercise.service.HotelService;

@RestController
public class HotelController {
    @Autowired
	public HotelService hserv;
    
    //post mapping
    @PostMapping("/postHotel")
    public String postHotel(@RequestBody HotelModel hr)
    {
    	hserv.saveHotel(hr);
    	return "data saved";
    }
    
    //get mapping
    @GetMapping("/getHotel")
    	public List<HotelModel>getHotelInfo()
    	{
    	return hserv.getHotel();
    	}
    
    //getUserByID
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId){
    	Optional<HotelModel>hotel=hserv.getUserId(userId);
    	
    	if(hotel!=null)
    	{
    		return ResponseEntity.ok(hotel); //Return the user's data if available
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
    }
    
    //put mapping
    @PutMapping("/updateHotel")
    public HotelModel updateHotelInfo(@RequestBody HotelModel ha)
    {
    	return hserv.updateHotel(ha);
    }
    @PutMapping("/updateHotelif/{id}")
    public ResponseEntity<String> updateHotelInfor(@PathVariable int id,@RequestBody HotelModel ha){
    	   boolean updated=hserv.updateHotelif(id,ha);
 			   if(updated)
 			   {
 				  return ResponseEntity.ok("Hotel with ID "+id+" updated successfully"); //.ok means sucess
 			   }
 			   else
 			   {
 				  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found and not updated");
 			   }
 	   }
    
   
    //Delete Mapping
    @DeleteMapping("/deleteHotel/{id}")
    public String removeHotel(@PathVariable("id") int hid)
    {
    	hserv.deleteHotel(hid);
    	return "Hotel with Id "+hid+" is deleted";
    }
    
    //delete mapping using request param
    @DeleteMapping("/byReqParm")
    public String removeByRequestPam(@RequestParam("id") int id)
    {
    	hserv.deleteHotel(id);
    	return "Hotel with Id "+id+" is deleted";
    }
    
   @DeleteMapping("/deleteHotelif/{id}")
   public ResponseEntity<String> deleteHotelInfo(@PathVariable int id){
	   boolean deleted=hserv.deleteHotelif(id);
	    if(deleted) {
	    	return ResponseEntity.ok("Hotel with ID "+id+"deleted successfully");
	    }
	    else 
	    {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found");
	    }
	    
	
   }
}
