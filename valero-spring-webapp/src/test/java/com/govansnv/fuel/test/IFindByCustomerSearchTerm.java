package com.govansnv.fuel.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.govansnv.fuel.config.AppConfig;
import com.govansnv.fuel.model.Customer;
import com.govansnv.fuel.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:customer-entries.xml")
@WebAppConfiguration
public class IFindByCustomerSearchTerm {

	@Autowired
	CustomerService customerService;

	@Test
	public void findBySearchTerm_FindAll() {
		List<Customer> searchResults = customerService.getAllCustomers();
		assertThat(searchResults).isNotEmpty();
	}

}
