package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.PurchaseOrderItem;

public interface PurchaseOrderItemDao {
	// Create a record in the purchase_order_item table
	public PurchaseOrderItem create(PurchaseOrderItem purchaseOrderItem);

	// Retrieve a single object
	public PurchaseOrderItem getPurchaseOrderItem(int id);

	// Retrieve all purchase_order_item objects from the table
	public List<PurchaseOrderItem> getAll();

	// Update purchaseOrderItem object in purchase_order_item table
	public void updatePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);

	// Remove the item
	public boolean remove(int id);
}
