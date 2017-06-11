package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.DriverDao;
import com.govansnv.fuel.model.Driver;

@Repository
public class DriverDaoImpl extends AbstractDao<Integer, Driver> implements DriverDao {
 
	static Log log = LogFactory.getLog(DriverDaoImpl.class.getName());
	
	@Transactional
	public Driver create(Driver driver) {
		persist(driver);
		return driver;
	}

	public Driver getDriver(int id) {
		try {
			Driver driver = (Driver) getEntityManager().createQuery("SELECT d FROM Driver d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();

			return driver;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<Driver> getAll() {
		List<Driver> drivers = getEntityManager().createQuery("SELECT d FROM Driver d  ORDER BY d.firstname ASC")
				.getResultList();
		return drivers;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updateDriver(Driver driver) {
		Driver d = (Driver) getEntityManager().createQuery("SELECT d FROM Driver d WHERE d.id = :Id")
				.setParameter("Id", driver.getId()).getSingleResult();
		if(d!=null){
			d.setFirstname(driver.getFirstname());
			d.setLastname(driver.getLastname());
			d.setPassnum(driver.getPassnum());
		}
		update(d);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the driver data");
		Driver driver = getDriver(id);
		if(driver!=null){
			delete(driver);
			return true;
		}		
		return false;		
	}
}
