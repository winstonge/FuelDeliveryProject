package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Driver;

public interface DriverService {
	
	public List getAllDrivers();
	
	public Driver getDriver(int id);
	
	public Driver addDriver(Driver driver);
	
	public Driver updateDriver(Driver driver);
	
	public boolean deleteDriver(int id);
}
