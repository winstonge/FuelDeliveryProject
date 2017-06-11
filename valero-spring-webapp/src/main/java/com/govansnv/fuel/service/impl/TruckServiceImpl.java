package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.TruckDao;
import com.govansnv.fuel.model.Truck;
import com.govansnv.fuel.service.TruckService;

@Service("truckService")
public class TruckServiceImpl implements TruckService {

	@Autowired
	TruckDao truckDao;
	public List getAllTrucks() {
		return truckDao.getAll();
	}

	public Truck getTruck(int id) {
		return truckDao.getTruck(id);
	}

	public Truck getTruckByNo(String truckNo) {
		return truckDao.getTruckByNo(truckNo);
	}
	
	public Truck addTruck(Truck truck) {		
		return truckDao.create(truck);
	}

	public Truck updateTruck(Truck truck) {
		truckDao.updateTruck(truck);
		return truck;
	}

	public boolean deleteTruck(int id) {
		return truckDao.remove(id);
	}


}
