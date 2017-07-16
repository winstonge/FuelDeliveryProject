package com.govansnv.fuel.model;

import java.sql.Timestamp;

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
 * This is our model class and it corresponds to refuel table in database
 */
@Entity
@Table(name="Refuel")
public class Refuel extends Fuel{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Device.class, fetch=FetchType.EAGER)
	private Device device;
	
	@ManyToOne(targetEntity=Truck.class, fetch=FetchType.EAGER)
	private Truck truck;
	
	
	@Column(name="gross_liters")
	private String grossLiters;
	
	@Column(name="dateadded")
	private Timestamp dateadded;
	
	@Column(name="tank_content")
	private String tankContent;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getGrossLiters() {
		return grossLiters;
	}

	public void setGrossLiters(String grossLiters) {
		this.grossLiters = grossLiters;
	}

	public String getTankContent() {
		return tankContent;
	}

	public void setTankContent(String tankContent) {
		this.tankContent = tankContent;
	}

	@ManyToOne
	@JoinColumn(name = "device_id")
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	@ManyToOne
	@JoinColumn(name = "truck_id")
	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Timestamp getDateadded() {
		return dateadded;
	}

	public void setDateadded(Timestamp dateadded) {
		this.dateadded = dateadded;
	}

	
}
