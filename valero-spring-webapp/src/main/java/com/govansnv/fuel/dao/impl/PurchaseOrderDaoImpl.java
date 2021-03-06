package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.PurchaseOrderDao;
import com.govansnv.fuel.model.PurchaseOrder;

@Repository
public class PurchaseOrderDaoImpl extends AbstractDao<Integer, PurchaseOrder> implements PurchaseOrderDao {
 
	private static Log log = LogFactory.getLog(PurchaseOrderDaoImpl.class.getName());
	
	@Transactional
	public PurchaseOrder create(PurchaseOrder purchaseOrder) {
		try{
			persist(purchaseOrder);
		}catch(Exception e){
			log.error(e.getMessage());
		}		
		return purchaseOrder;
	}

	public PurchaseOrder getPurchaseOrder(int id) {
		try {
			PurchaseOrder purchaseOrder = (PurchaseOrder) getEntityManager().createQuery("SELECT d FROM purchase_order d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();
			return purchaseOrder;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<PurchaseOrder> getAll() {
		List<PurchaseOrder> orders = getEntityManager().createQuery("SELECT d FROM purchase_order d  ORDER BY 1 ASC")
				.getResultList();
		return orders;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		PurchaseOrder order = (PurchaseOrder) getEntityManager().createQuery("SELECT d FROM purchase_order d WHERE d.id = :Id")
				.setParameter("Id", purchaseOrder.getId()).getSingleResult();
		if(order!=null){
			order.setTicketNo(purchaseOrder.getTicketNo());
			order.setTruckNumber(purchaseOrder.getTruckNumber());
			order.setDeliveredOn(purchaseOrder.getDeliveredOn());
			order.setFuelName(purchaseOrder.getFuelName());
			order.setFuelPrice(purchaseOrder.getFuelPrice());
			order.setPurchaseDate(purchaseOrder.getPurchaseDate());
			order.setPurchaseVolume(purchaseOrder.getPurchaseVolume());
		}
		update(order);
	}
	
	@Transactional
	public boolean remove(int id) {
		
		PurchaseOrder order = getPurchaseOrder(id);
		if(order!=null){
			delete(order);
			log.info("Purchase_order data deleted");
			return true;
		}		
		return false;		
	}
}
