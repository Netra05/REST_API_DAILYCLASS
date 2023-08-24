package com.portal.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.portal.exercise.model.Catering;
import com.portal.exercise.repository.CateringRepo;

@Service
public class CateringServ {
@Autowired
public CateringRepo crep;

//post the data
public String saveCater(Catering c)
{
	  crep.save(c);
	  return "Data is saved to the database";
}

//get the data

public List<Catering>getCatering()
{
	  return crep.findAll();
}

//getUserByID
public Optional<Catering>getUserId(int userId)
{
	  Optional<Catering>cater=crep.findById(userId);
	  if(cater.isPresent())
	  {
		  return cater;
	  }
	  return null;
}



//update the data(put)
public Catering updateCatering(Catering cm)
{
	  return crep.saveAndFlush(cm);
}

//update the data if id present
public boolean updateCateringif(int CateringId,Catering cm) {
	  if(crep.existsById(CateringId)) {
		  crep.save(cm);
		  return true;
	  }
	  return false;
}

// sort 
public List<Catering>sortByAsc(String hotelName)
{
	return crep.findAll(Sort.by(hotelName).ascending()); 
//	return crep.findAll(Sort.by(hotelName).descending());
}

//pagination
public List<Catering>pagination(int pageNum,int pageSize)
{
	Page<Catering>cont=crep.findAll(PageRequest.of(pageNum,pageSize));
	return cont.getContent();
}

//pagination and sorting
public List<Catering>paginationAndSorting(int pageNum,int pageSize,String name)
{
	Page<Catering>cont1=crep.findAll(PageRequest.of(pageNum,pageSize,Sort.by(name)));
	return cont1.getContent();
}
}
