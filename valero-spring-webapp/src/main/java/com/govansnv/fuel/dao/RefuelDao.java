package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Refuel;

public interface RefuelDao {

	// Create a record in the refuel table
	public Refuel create(Refuel refuel);

	// Retrieve a single object
	public Refuel getRefuel(int id);

	// Retrieve all refuel objects from the table
	public List<Refuel> getAll();

	// Update truck object in refuel table
	public void updateRefuel(Refuel fuelDelivery);
	
	//Remove the item
	public boolean remove(int id);
}
