package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.PurchaseOrderItemDao;
import com.govansnv.fuel.model.PurchaseOrderItem;
import com.govansnv.fuel.service.PurchaseOrderItemService;

@Service("purchaseOrderService")
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

	@Autowired
	PurchaseOrderItemDao purchaseOrderItemDao;

	public List getAllPurchaseOrderItems() {
		return purchaseOrderItemDao.getAll();
	}

	public PurchaseOrderItem getPurchaseOrderItem(int id) {
		return purchaseOrderItemDao.getPurchaseOrderItem(id);
	}

	public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public PurchaseOrderItem updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePurchaseOrderItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
