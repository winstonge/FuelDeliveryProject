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
 * This is our model class and it corresponds to Company table in database
 */
@Entity
@Table(name = "Device")
public class Device {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "device_no")
	private int deviceNo;

	@Column( name = "last_synch")
	private Timestamp lastSynch;

	@ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
	private Department department;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(int deviceNo) {
		this.deviceNo = deviceNo;
	}

	public Timestamp getLastSynch() {
		return lastSynch;
	}

	public void setLastSynch(Timestamp lastSynch) {
		this.lastSynch = lastSynch;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", deviceNo=" + deviceNo + ", lastSynch=" + lastSynch + "]";
	}
	
	
}
