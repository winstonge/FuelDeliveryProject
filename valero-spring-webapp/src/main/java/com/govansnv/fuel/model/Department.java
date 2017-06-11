package com.govansnv.fuel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Department table in database
 */
@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@ManyToOne(targetEntity=Company.class, fetch=FetchType.EAGER)
	private Company company;
	
	@OneToMany(targetEntity=Device.class, mappedBy="department", fetch=FetchType.EAGER)
	private Set<Device> devices;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@ManyToOne
    @JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	public Set<Device> getDevices() {
		return devices;
	}
	
}
