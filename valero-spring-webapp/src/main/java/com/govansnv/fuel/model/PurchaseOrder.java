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
		
	@Column(name = "driver_badge")
	private int driverBadge;
	
	@Column(name = "driver_firstname")
	private int driverFirstname;
	
	@Column(name = "driver_lastname")
	private int driverLastname;
	
	@Column(name = "cust_firstname")
	private int custFirstname;
	
	@Column(name = "cust_lastname")
	private int custLastname;
	
	@Column(name = "driver_signature")
	private int driverSignature;
	
	@Column(name = "cust_signature")
	private int customerSignature;
	
	@Column(name = "deivered_on")
	private int deliveredOn;

	@ManyToOne(targetEntity=Customer.class, fetch=FetchType.EAGER)
	private Customer customer;
	
	@ManyToOne(targetEntity=Truck.class, fetch=FetchType.EAGER)
	private Truck truck;


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

	public int getDriverBadge() {
		return driverBadge;
	}

	public void setDriverBadge(int driverBadge) {
		this.driverBadge = driverBadge;
	}

	public int getDriverFirstname() {
		return driverFirstname;
	}

	public void setDriverFirstname(int driverFirstname) {
		this.driverFirstname = driverFirstname;
	}

	public int getDriverLastname() {
		return driverLastname;
	}

	public void setDriverLastname(int driverLastname) {
		this.driverLastname = driverLastname;
	}

	public int getCustFirstname() {
		return custFirstname;
	}

	public void setCustFirstname(int custFirstname) {
		this.custFirstname = custFirstname;
	}

	public int getCustLastname() {
		return custLastname;
	}

	public void setCustLastname(int custLastname) {
		this.custLastname = custLastname;
	}

	public int getDriverSignature() {
		return driverSignature;
	}

	public void setDriverSignature(int driverSignature) {
		this.driverSignature = driverSignature;
	}

	public int getCustomerSignature() {
		return customerSignature;
	}

	public void setCustomerSignature(int customerSignature) {
		this.customerSignature = customerSignature;
	}

	@ManyToOne
    @JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}
	
	@ManyToOne
    @JoinColumn(name = "truck_id")
	public Truck getTruck() {
		return truck;
	}

}
