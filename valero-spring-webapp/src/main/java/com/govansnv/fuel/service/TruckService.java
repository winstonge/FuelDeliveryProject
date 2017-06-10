package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.PurchaseOrder;
import com.govansnv.fuel.model.Truck;

public interface TruckService {
	
	public List getAllTrucks();
	
	public Truck getTruck(int id);
	
	public Truck addTruck(Truck truck);
	
	public Truck updateTruck(Truck Truck);
	
	public boolean deleteTruck(int id);
}
