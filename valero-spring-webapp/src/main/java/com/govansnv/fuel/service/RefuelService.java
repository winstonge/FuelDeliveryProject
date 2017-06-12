package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Refuel;

public interface RefuelService {
	
	public List getAllRefuels();
	
	public Refuel getRefuel(int id);
	
	public Refuel addRefuel(Refuel refuel);
	
	public Refuel updateRefuel(Refuel refuel);
	
	public boolean deleteRefuel(int id);
}
