package com.portal.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portal.exercise.model.ChocolateModel;

import jakarta.transaction.Transactional;

public interface ChocoRepo extends JpaRepository<ChocolateModel,Integer> {
	
	//native query
	@Query(value="select * from coco",nativeQuery=true)
	public List<ChocolateModel>getAllRows();

	@Query(value="select * from coco where brand like %?1%",nativeQuery=true)
	public List<ChocolateModel> getByname(@Param("name") String name);
	
	
	@Query(value="select * from coco where brand=:name and choc_name=:cname",nativeQuery = true )
	public List<ChocolateModel>getSpecRows(@Param("name") String name,@Param("cname") String cname);
	
	//Delete using native query
	@Modifying
	@Transactional
//	@Query(value="delete from coco where choco_id=:id",nativeQuery=true)
//	public int deleteId(@Param("id")int id);
	@Query("delete from ChocolateModel c where c.ChocoId=:id")
	public int deleteId(@Param("id")int id);
	
	
	//Update the native query
	@Modifying
	@Transactional
	@Query(value="update coco set brand=:name where choco_id=:id",nativeQuery=true)
	public Integer updateByid(@Param("name") String name,@Param("id")int id);
	
	
	//JQL query
	@Query("select c from ChocolateModel c where c.ChocoName like %?1%")
	public List<ChocolateModel>getByCoco(@Param("name") String name);
	
	
	
}


