package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.PurchaseOrder;

public interface PurchaseOrderService {
	
	public List getAllPurchaseOrders();
	
	public PurchaseOrder getPurchaseOrder(int id);
	
	public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder);
	
	public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder);
	
	public boolean deletePurchaseOrder(int id);
}
