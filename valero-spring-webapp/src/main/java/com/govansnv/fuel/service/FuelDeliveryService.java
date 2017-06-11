package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.FuelDelivery;

public interface FuelDeliveryService {
	
	public List getAllFuelDeliveries();
	
	public FuelDelivery getFuelDelivery(int id);
	
	public FuelDelivery addFuelDelivery(FuelDelivery fuelDelivery);
	
	public FuelDelivery updateFuelDelivery(FuelDelivery fuelDelivery);
	
	public boolean deleteFuelDelivery(int id);
}
