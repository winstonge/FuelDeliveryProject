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
 
	static Log log = LogFactory.getLog(PurchaseOrderDaoImpl.class.getName());
	
	@Transactional
	public PurchaseOrder create(PurchaseOrder purchaseOrder) {
		persist(purchaseOrder);
		return purchaseOrder;
	}

	public PurchaseOrder getPurchaseOrder(int id) {
		try {
			PurchaseOrder purchaseOrder = (PurchaseOrder) getEntityManager().createQuery("SELECT d FROM purchase_order d WHERE d.id LIKE :Id")
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
		PurchaseOrder order = (PurchaseOrder) getEntityManager().createQuery("SELECT d FROM purchase_order d WHERE d.id LIKE :Id")
				.setParameter("Id", purchaseOrder.getId()).getSingleResult();
		if(order!=null){
			order.setDriverFirstname(purchaseOrder.getDriverFirstname());
			order.setDriverLastname(purchaseOrder.getDriverLastname());
			order.setCustFirstname(purchaseOrder.getCustFirstname());
			order.setCustLastname(purchaseOrder.getCustLastname());
			order.setDriverBadge(purchaseOrder.getDriverBadge());
			order.setDriverSignature(purchaseOrder.getDriverSignature());
			order.setTicketNo(purchaseOrder.getCustomerSignature());
		}
		update(order);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the purchase_order data");
		PurchaseOrder order = getPurchaseOrder(id);
		if(order!=null){
			delete(order);
			return true;
		}		
		return false;		
	}
}
