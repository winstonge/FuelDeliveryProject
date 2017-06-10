package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Truck;

public interface TruckDao {

	// Create a record in the truck table
	public Truck create(Truck truck);

	// Retrieve a single object
	public Truck getTruck(int id);

	// Retrieve all truck objects from the table
	public List<Truck> getAll();

	// Update truck object in truck table
	public void updateTruck(Truck truck);
	
	//Remove the item
	public boolean remove(int id);
}
