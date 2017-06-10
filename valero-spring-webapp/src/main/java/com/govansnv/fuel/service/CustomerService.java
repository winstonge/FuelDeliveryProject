package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Customer;

public interface CustomerService {
	
public List<Customer> getAllCustomers();
	
	public Customer getCustomer(int id);
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public boolean deleteCustomer(int id);

}
