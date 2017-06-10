package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Customer;

public interface CustomerDao {
	// Create a record in the department table
	public Customer create(Customer customer);

	// Retrieve a single object
	public Customer getCustomer(int id);

	// Retrieve all department objects from the table
	public List<Customer> getAll(); 

	// Update driver object in department table
	public Customer updateCustomer(Customer customer);
	
	//Remove the item
	public boolean remove(int id);
}
