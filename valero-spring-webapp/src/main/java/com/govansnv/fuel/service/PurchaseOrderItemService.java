package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.PurchaseOrderItem;

public interface PurchaseOrderItemService {
	
	public List getAllPurchaseOrderItems();
	
	public PurchaseOrderItem getPurchaseOrderItem(int id);
	
	public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);
	
	public PurchaseOrderItem updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);
	
	public boolean deletePurchaseOrderItem(int id);
}
