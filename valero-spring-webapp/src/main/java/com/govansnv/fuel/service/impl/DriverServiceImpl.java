package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.DriverDao;
import com.govansnv.fuel.model.Driver;
import com.govansnv.fuel.service.DriverService;

@Service("driverService")
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverDao driverDao;

	public List getAllDrivers() {
		return driverDao.getAll();
	}

	public Driver getDriver(int id) {
		return driverDao.getDriver(id);
	}

	public Driver addDriver(Driver driver) {
		Driver d = driverDao.create(driver);
		return d;
	}

	public Driver updateDriver(Driver driver) {
		driverDao.updateDriver(driver);
		return driver;
	}

	public boolean deleteDriver(int id) {
		return driverDao.remove(id);
	}

}
