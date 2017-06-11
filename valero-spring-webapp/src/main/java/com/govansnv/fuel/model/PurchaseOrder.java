package com.govansnv.fuel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "ticket_no")
	private int ticketNo;
	
	@Column(name = "purchase_date")
	private int purchaseDate;
		
	@Column(name = "delivered_on")
	private int deliveredOn;
	
	@Column(name = "purchase_volume")
	private int purchaseVolume;
	
	@Column(name = "fuel_price")
	private int fuelPrice;

	@Column(name = "truck_number")
	private int truckNumber;
	
	@Column(name = "fuel_name")
	private int fuelName;
	
	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.EAGER)
	private Customer customer;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public int getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(int purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(int deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	public int getPurchaseVolume() {
		return purchaseVolume;
	}

	public void setPurchaseVolume(int purchaseVolume) {
		this.purchaseVolume = purchaseVolume;
	}

	public int getFuelPrice() {
		return fuelPrice;
	}

	public void setFuelPrice(int fuelPrice) {
		this.fuelPrice = fuelPrice;
	}

	public int getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(int truckNumber) {
		this.truckNumber = truckNumber;
	}

	public int getFuelName() {
		return fuelName;
	}

	public void setFuelName(int fuelName) {
		this.fuelName = fuelName;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
    @JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}
	
}
