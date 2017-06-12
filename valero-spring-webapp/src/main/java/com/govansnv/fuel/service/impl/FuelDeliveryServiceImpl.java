package com.govansnv.fuel.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.FuelDeliveryDao;
import com.govansnv.fuel.model.FuelDelivery;
import com.govansnv.fuel.service.FuelDeliveryService;

@Service("fuelDeliveryService")
public class FuelDeliveryServiceImpl implements FuelDeliveryService {

	@Autowired
	FuelDeliveryDao fuelDeliveryDao;
	
	public List getAllFuelDeliveries() {
		return fuelDeliveryDao.getAll();
	}

	public FuelDelivery getFuelDelivery(int id) {
		return fuelDeliveryDao.getFuelDelivery(id);
	}

	public FuelDelivery addFuelDelivery(FuelDelivery fuelDelivery) {		
		FuelDelivery d = fuelDeliveryDao.create(fuelDelivery);
		return d;
	}

	public FuelDelivery updateFuelDelivery(FuelDelivery fuelDelivery) {
		fuelDeliveryDao.updateFuelDelivery(fuelDelivery);
		return fuelDelivery;
	}

	public boolean deleteFuelDelivery(int id) {
		return fuelDeliveryDao.remove(id);
	}

}
