package com.govansnv.fuel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.govansnv.fuel.model.Customer;
import com.govansnv.fuel.service.CustomerService;

@RestController
public class CustomerRestController {
	static Log log = LogFactory.getLog(CustomerRestController.class.getName());
		
	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getDrivers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}
}
