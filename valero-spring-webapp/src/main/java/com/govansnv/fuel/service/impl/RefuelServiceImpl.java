package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.RefuelDao;
import com.govansnv.fuel.model.Refuel;
import com.govansnv.fuel.service.RefuelService;

@Service("refuelService")
public class RefuelServiceImpl implements RefuelService {

	@Autowired
	RefuelDao refuelDao;
	
	public List getAllRefuels() {
		return refuelDao.getAll();
	}

	public Refuel getRefuel(int id) {
		return refuelDao.getRefuel(id);
	}

	public Refuel addRefuel(Refuel refuel) {		
		Refuel d = refuelDao.create(refuel);
		return d;
	}

	public Refuel updateRefuel(Refuel refuel) {
		refuelDao.updateRefuel(refuel);
		return refuel;
	}

	public boolean deleteRefuel(int id) {
		return refuelDao.remove(id);
	}

}
