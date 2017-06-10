package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Driver;

public interface DriverDao {

	// Create a record in the driver table
	public Driver create(Driver driver);

	// Retrieve a single object
	public Driver getDriver(int id);

	// Retrieve all driver objects from the table
	public List<Driver> getAll();

	// Update driver object in driver table
	public void updateDriver(Driver driver);
	
	//Remove the item
	public boolean remove(int id);
}
