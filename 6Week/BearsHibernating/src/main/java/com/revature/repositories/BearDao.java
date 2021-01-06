package com.revature.repositories;

import java.util.List;

import com.revature.models.Bear;

public interface BearDao {
	//default methods you should have from a dao
	
	//findall
	public List<Bear> findAll();
	//findbyid
	public Bear getOne(int id);
	//update
	public Bear updateBear(Bear b);
	//saveNew
	public Bear buildABear(Bear b);
	//delete
	public void deleteBear(Bear b);
	
	public List<Bear> findBearByColour(String Colour);
	
	public List<Bear> bearByCriteria();
}
