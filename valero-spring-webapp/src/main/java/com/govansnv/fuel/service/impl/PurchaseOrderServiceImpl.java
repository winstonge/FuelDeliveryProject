package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.PurchaseOrderDao;
import com.govansnv.fuel.model.PurchaseOrder;
import com.govansnv.fuel.service.PurchaseOrderService;

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	
	public List getAllPurchaseOrders() {
		return purchaseOrderDao.getAll();
	}

	public PurchaseOrder getPurchaseOrder(int id) {
		return purchaseOrderDao.getPurchaseOrder(id);
	}

	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
		PurchaseOrder order = purchaseOrderDao.create(purchaseOrder);
		return order;
	}

	public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderDao.updatePurchaseOrder(purchaseOrder);
		return purchaseOrder;
	}

	public boolean deletePurchaseOrder(int id) {
		return purchaseOrderDao.remove(id);
	}
}
