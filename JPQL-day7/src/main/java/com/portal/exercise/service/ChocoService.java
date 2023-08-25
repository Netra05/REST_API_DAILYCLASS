package com.portal.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.ChocolateModel;
import com.portal.exercise.repository.ChocoRepo;



@Service
public class ChocoService {
	@Autowired
	public ChocoRepo crepo;
	
	//get the data
	  public List<ChocolateModel>getCoco()
	  {
		  return crepo.findAll();
	  }
	  
	  //put mapping 
	  public ChocolateModel updateCoco(ChocolateModel cm)
	  {
		  return crepo.saveAndFlush(cm);
	  }
	  //get all the data
	  public List<ChocolateModel>getAllrows()
	  {
		  return crepo.getAllRows();
	  }
      //get specific rows
	  public List<ChocolateModel>getSpecrows(String add,String name)
	  {
		  return crepo.getSpecRows(add,name);
	  }
	  
	  //delete the data
	  public int deleteRowByid(int id)
	  {
		  return crepo.deleteId(id);
	  }
	  
	  //update the data
	  public Integer updateRow(String name,int id)
	  {
		  return crepo.updateByid(name, id);
	  }
	  
	  //JQL QUERY
	  public List<ChocolateModel>getBy(String name)
	  {
		  return crepo.getByCoco(name);
	  }
}
