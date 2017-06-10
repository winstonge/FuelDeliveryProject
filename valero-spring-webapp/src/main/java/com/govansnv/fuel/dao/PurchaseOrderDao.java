package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.PurchaseOrder;

public interface PurchaseOrderDao {

	// Create a record in the purchase_order table
	public PurchaseOrder create(PurchaseOrder purchaseOrder);

	// Retrieve a single object
	public PurchaseOrder getPurchaseOrder(int id);

	// Retrieve all purchase_order objects from the table
	public List<PurchaseOrder> getAll();

	// Update purchaseOrder object in purchase_order table
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);
	
	//Remove the item
	public boolean remove(int id);
}
