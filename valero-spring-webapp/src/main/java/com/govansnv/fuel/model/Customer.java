package com.govansnv.fuel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name = "Customer")
public class Customer {	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_sold_to")
	private String customerSoldTo;
	
	@Column(name = "customer_ship_to")
	private String customerShipTo;
	
	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "ship_to")
	private String shipTo;
	
	@ManyToOne(targetEntity=Company.class, fetch=FetchType.EAGER)
	private Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerSoldTo() {
		return customerSoldTo;
	}

	public void setCustomerSoldTo(String customerSoldTo) {
		this.customerSoldTo = customerSoldTo;
	}

	public String getCustomerShipTo() {
		return customerShipTo;
	}

	public void setCustomerShipTo(String customerShipTo) {
		this.customerShipTo = customerShipTo;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}	
	
	
}
