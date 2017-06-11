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
 * This is our model class and it corresponds to Truck table in database
 */
@Entity
@Table(name="Truck")
public class Truck {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Department.class, fetch=FetchType.EAGER)
	private Department department;
	
	@Column(name="truck_code")
	private String truckCode;
	
	@Column(name="truck_volume")
	private int truckVolume;
	
	@Column(name="number_of_meters")
	private int numberOfMeters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
    @JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public String getTruckCode() {
		return truckCode;
	}

	public void setTruckCode(String truckCode) {
		this.truckCode = truckCode;
	}

	public int getTruckVolume() {
		return truckVolume;
	}

	public void setTruckVolume(int truckVolume) {
		this.truckVolume = truckVolume;
	}

	public int getNumberOfMeters() {
		return numberOfMeters;
	}

	public void setNumberOfMeters(int numberOfMeters) {
		this.numberOfMeters = numberOfMeters;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", department=" + department + ", truckCode=" + truckCode + ", truckVolume="
				+ truckVolume + ", numberOfMeters=" + numberOfMeters + "]";
	}
	
	

}
