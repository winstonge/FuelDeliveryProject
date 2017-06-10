package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.CustomerDao;
import com.govansnv.fuel.model.Customer;
import com.govansnv.fuel.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List getAllCustomers() {
		return customerDao.getAll();
	}

	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}

	public Customer addCustomer(Customer customer) {
		Customer d = customerDao.create(customer);
		return d;
	}

	public Customer updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return customer;
	}

	public boolean deleteCustomer(int id) {
		return customerDao.remove(id);
	}

}
