package com.portal.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.exercise.model.ChocolateModel;

import com.portal.exercise.service.ChocoService;

@RestController
public class ChocoContro {
	 @Autowired
		public ChocoService cserv;
	 
	 //get mapping
	    @GetMapping("/getCoco")
	    	public List<ChocolateModel>getCocoInfo()
	    	{
	    	return cserv.getCoco();
	    	}
	    
	    @PutMapping("/updateCoco")
	    public ChocolateModel updateCocoInfo(@RequestBody ChocolateModel ca)
	    {
	    	return cserv.updateCoco(ca);
	    }
	    
	  //get all the data
		 @GetMapping("/getAllRows")
		 public List<ChocolateModel> getallRows()
		 {
			 return cserv.getAllrows();
		 }
		 //get specific data
		 @GetMapping("/getSpecific/{add}/{name}")
		 public List<ChocolateModel> getSpec(@PathVariable("add") String add,@PathVariable("name") String name)
		 {
			 return cserv.getSpecrows(add,name);
		}
		 //delete
		 @DeleteMapping("/deleteRow/{id}")
		 public String deleteRow(@PathVariable("id") int id) {
			 return cserv.deleteRowByid(id)+" id deleted";
		 }
		 
		 //update
		 @PutMapping("/updateId/{add}/{id}")
		 public String updateInfo(@PathVariable("add") String add,@PathVariable("id") int id)
		 {
			 return cserv.updateRow(add, id)+" rows are updated";
		 }
		 
		 //JQL Query
		 @GetMapping("/getJQL/{name}")
		 public List<ChocolateModel>getSpec1(@PathVariable("name") String name)
		 {
			 return cserv.getBy(name);
		 }
}
