package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.TruckDao;
import com.govansnv.fuel.model.Truck;

@Repository
public class TruckDaoImpl extends AbstractDao<Integer, Truck> implements TruckDao {
 
	static Log log = LogFactory.getLog(TruckDaoImpl.class.getName());
	
	@Transactional
	public Truck create(Truck truck) {
		persist(truck);
		return truck;
	}

	public Truck getTruck(int id) {
		try {
			Truck truck = (Truck) getEntityManager().createQuery("SELECT d FROM truck d WHERE d.id LIKE :Id")
					.setParameter("Id", id).getSingleResult();
			return truck;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<Truck> getAll() {
		List<Truck> trucks = getEntityManager().createQuery("SELECT d FROM truck d  ORDER BY 1 ASC")
				.getResultList();
		return trucks;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updateTruck(Truck truck) {
		Truck tr = (Truck) getEntityManager().createQuery("SELECT d FROM truck d WHERE d.id LIKE :Id")
				.setParameter("Id", truck.getId()).getSingleResult();
		if(tr!=null){
			tr.setTruckCode(truck.getTruckCode());
			tr.setNumberOfMeters(truck.getNumberOfMeters());
			tr.setTruckVolume(truck.getTruckVolume());
		}
		update(tr);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the truck data");
		Truck truck = getTruck(id);
		if(truck!=null){
			delete(truck);
			return true;
		}		
		return false;		
	}
}
