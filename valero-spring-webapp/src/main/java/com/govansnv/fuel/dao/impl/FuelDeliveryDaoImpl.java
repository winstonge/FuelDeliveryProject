package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.FuelDeliveryDao;
import com.govansnv.fuel.model.FuelDelivery;

@Repository
public class FuelDeliveryDaoImpl extends AbstractDao<Integer, FuelDelivery> implements FuelDeliveryDao {
 
	static Log log = LogFactory.getLog(FuelDeliveryDaoImpl.class.getName());
	
	@Transactional
	public FuelDelivery create(FuelDelivery truck) {
		persist(truck);
		return truck;
	}

	public FuelDelivery getFuelDelivery(int id) {
		try {
			FuelDelivery delivery = (FuelDelivery) getEntityManager().createQuery("SELECT d FROM fuel_delivery d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();
			return delivery;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<FuelDelivery> getAll() {
		List<FuelDelivery> deliveries = getEntityManager().createQuery("SELECT d FROM fuel_delivery d ORDER BY 1 ASC")
				.getResultList();
		return deliveries;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updateFuelDelivery(FuelDelivery delivery) {
		FuelDelivery dlr = (FuelDelivery) getEntityManager().createQuery("SELECT d FROM fuel_delivery d WHERE d.id = :Id")
				.setParameter("Id", delivery.getId()).getSingleResult();
		if(dlr!=null){
			dlr.setPurchaseOrderItem(delivery.getPurchaseOrderItem());
			dlr.setDevice(delivery.getDevice());
			dlr.setMeterOpenOne(delivery.getMeterOpenOne());
			dlr.setMeterOpenTwo(delivery.getMeterOpenTwo());
			dlr.setMeterCloseOne(delivery.getMeterCloseOne());
			dlr.setMeterCloseTwo(delivery.getMeterCloseTwo());
			dlr.setTotalFueled(delivery.getTotalFueled());
			dlr.setFuelPrice(delivery.getFuelPrice());
			dlr.setExtraPoints(delivery.getExtraPoints());			
		}
		update(dlr);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the fuel delivery data");
		FuelDelivery delivery = getFuelDelivery(id);
		if(delivery!=null){
			delete(delivery);
			return true;
		}		
		return false;		
	}
}
