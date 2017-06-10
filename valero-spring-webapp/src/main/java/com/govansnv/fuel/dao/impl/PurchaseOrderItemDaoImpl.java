package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.PurchaseOrderItemDao;
import com.govansnv.fuel.model.PurchaseOrder;
import com.govansnv.fuel.model.PurchaseOrderItem;

@Repository
public class PurchaseOrderItemDaoImpl extends AbstractDao<Integer, PurchaseOrderItem> implements PurchaseOrderItemDao {
 
	static Log log = LogFactory.getLog(PurchaseOrderItemDaoImpl.class.getName());
	
	@Transactional
	public PurchaseOrderItem create(PurchaseOrderItem purchaseOrderItem) {
		persist(purchaseOrderItem);
		return purchaseOrderItem;
	}

	public PurchaseOrderItem getPurchaseOrderItem(int id) {
		try {
			PurchaseOrderItem purchaseOrderItem = (PurchaseOrderItem) getEntityManager().createQuery("SELECT d FROM purchase_order_item d WHERE d.id LIKE :Id")
					.setParameter("Id", id).getSingleResult();
			return purchaseOrderItem;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<PurchaseOrderItem> getAll() {
		List<PurchaseOrderItem> orderItems = getEntityManager().createQuery("SELECT d FROM purchase_order_item d ORDER BY 1 ASC")
				.getResultList();
		return orderItems;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		PurchaseOrderItem item = (PurchaseOrderItem) getEntityManager().createQuery("SELECT d FROM purchase_order_item d WHERE d.id LIKE :Id")
				.setParameter("Id", purchaseOrderItem.getId()).getSingleResult();
		if(item!=null){			
			item.setExtraPoints(purchaseOrderItem.getExtraPoints());
			item.setSmallDelivery(purchaseOrderItem.getSmallDelivery());
			item.setMeterOpenOne(purchaseOrderItem.getMeterOpenOne());
			item.setMeterOpenTwo(purchaseOrderItem.getMeterOpenTwo());
			item.setMeterCloseOne(purchaseOrderItem.getMeterCloseOne());
			item.setMeterCloseTwo(purchaseOrderItem.getMeterCloseTwo());
			item.setTotalFueled(purchaseOrderItem.getTotalFueled());
			item.setFuelPrice(purchaseOrderItem.getFuelPrice());
		}
		update(purchaseOrderItem);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the purchase_order_item data");
		PurchaseOrderItem orderItem = getPurchaseOrderItem(id);
		if(orderItem!=null){
			delete(orderItem);
			return true;
		}		
		return false;		
	}
}
