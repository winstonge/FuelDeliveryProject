package com.govansnv.fuel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order_item")
public class PurchaseOrderItem {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "small_delivery")
	private int smallDelivery;
	
	@Column(name = "meter_open_one")
	private int meterOpenOne;
	
	@Column(name = "meter_close_one")
	private int meterCloseOne;
	
	@Column(name = "meter_open_two")
	private int meterOpenTwo;
	
	@Column(name = "meter_close_two")
	private int meterCloseTwo;
	
	@Column(name = "total_fueled")
	private int totalFueled;
	
	@Column(name = "fuel_price")
	private double fuelPrice;
	
	@Column(name = "extra_points")
	private int extraPoints;
	
	@ManyToOne(targetEntity=PurchaseOrder.class, fetch=FetchType.EAGER)
	private PurchaseOrder purchaseOrder;

	@ManyToOne
    @JoinColumn(name = "purchase_order_id")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSmallDelivery() {
		return smallDelivery;
	}

	public void setSmallDelivery(int smallDelivery) {
		this.smallDelivery = smallDelivery;
	}

	public int getMeterOpenOne() {
		return meterOpenOne;
	}

	public void setMeterOpenOne(int meterOpenOne) {
		this.meterOpenOne = meterOpenOne;
	}

	public int getMeterCloseOne() {
		return meterCloseOne;
	}

	public void setMeterCloseOne(int meterCloseOne) {
		this.meterCloseOne = meterCloseOne;
	}

	public int getMeterOpenTwo() {
		return meterOpenTwo;
	}

	public void setMeterOpenTwo(int meterOpenTwo) {
		this.meterOpenTwo = meterOpenTwo;
	}

	public int getMeterCloseTwo() {
		return meterCloseTwo;
	}

	public void setMeterCloseTwo(int meterCloseTwo) {
		this.meterCloseTwo = meterCloseTwo;
	}

	public int getTotalFueled() {
		return totalFueled;
	}

	public void setTotalFueled(int totalFueled) {
		this.totalFueled = totalFueled;
	}

	public double getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(double fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	public int getExtraPoints() {
		return extraPoints;
	}

	public void setExtraPoints(int extraPoints) {
		this.extraPoints = extraPoints;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	
	
}
