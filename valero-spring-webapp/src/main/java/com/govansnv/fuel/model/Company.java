package com.govansnv.fuel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Company table in database
 */
@Entity
@Table(name = "Company")
public class Company {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(targetEntity=Department.class, mappedBy="company", fetch=FetchType.EAGER)
	private Set<Department> departments;
	
	@OneToMany(targetEntity=Customer.class, mappedBy="company", fetch=FetchType.EAGER)
	private Set<Customer> customers;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "fax")
	private String fax;

	@Column(name = "address")
	private String addres;

	@Column(name = "city")
	private String city;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "slogan")
	private String slogan;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	public Set<Department> getDepartments() {
		return departments;
	}
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", phone=" + phone + ", fax=" + fax + ", addres="
				+ addres + ", city=" + city + ", slogan=" + slogan + "]";
	}

}
