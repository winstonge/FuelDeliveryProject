package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.FuelDelivery;

public interface FuelDeliveryDao {

	// Create a record in the fuel delivery table
	public FuelDelivery create(FuelDelivery fuelDelivery);

	// Retrieve a single object
	public FuelDelivery getFuelDelivery(int id);

	// Retrieve all fuel delivery objects from the table
	public List<FuelDelivery> getAll();

	// Update truck object in fuel delivery table
	public void updateFuelDelivery(FuelDelivery fuelDelivery);
	
	//Remove the item
	public boolean remove(int id);
}
