package com.govansnv.fuel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to fuel_delivery table in database
 */
@Entity
@Table(name = "fuel_delivery")
public class FuelDelivery {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "purchase_order_item")
	private String purchaseOrderItem;
	
	@Column(name = "meter_open_one")
	private String meterOpenOne;
	
	@Column(name = "meter_close_one")
	private String meterCloseOne;
	
	@Column(name = "meter_open_two")
	private String meterOpenTwo;
	
	@Column(name = "meter_close_two")
	private String meterCloseTwo;
	
	@Column(name = "total_fueled")
	private String totalFueled;
	
	@Column(name = "fuel_price")
	private String fuelPrice;
	
	@Column(name = "extra_points")
	private String extraPoints;
	
	@ManyToOne(targetEntity=Device.class, fetch=FetchType.EAGER)
	private Device device;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(String purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}



	public String getMeterOpenOne() {
		return meterOpenOne;
	}

	public void setMeterOpenOne(String meterOpenOne) {
		this.meterOpenOne = meterOpenOne;
	}

	public String getMeterCloseOne() {
		return meterCloseOne;
	}

	public void setMeterCloseOne(String meterCloseOne) {
		this.meterCloseOne = meterCloseOne;
	}

	public String getMeterOpenTwo() {
		return meterOpenTwo;
	}

	public void setMeterOpenTwo(String meterOpenTwo) {
		this.meterOpenTwo = meterOpenTwo;
	}

	public String getMeterCloseTwo() {
		return meterCloseTwo;
	}

	public void setMeterCloseTwo(String meterCloseTwo) {
		this.meterCloseTwo = meterCloseTwo;
	}

	public String getTotalFueled() {
		return totalFueled;
	}

	public void setTotalFueled(String totalFueled) {
		this.totalFueled = totalFueled;
	}

	public String getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(String fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	public String getExtraPoints() {
		return extraPoints;
	}

	public void setExtraPoints(String extraPoints) {
		this.extraPoints = extraPoints;
	}

	@ManyToOne
	@JoinColumn(name = "device_id")
	public Device getDevice() {
		return device;
	}	
}
