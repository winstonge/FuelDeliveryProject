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
import com.govansnv.fuel.model.Department;
import com.govansnv.fuel.model.Driver;
import com.govansnv.fuel.service.DepartmentService;
import com.govansnv.fuel.service.DriverService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:driver-entries.xml")
@WebAppConfiguration
public class IFindBySearchTermTest {

	@Autowired
	DriverService driverService;
	@Autowired
	DepartmentService departService;

	@Test
	public void findBySearchTerm_FindAll() {
		List<Driver> searchResults = driverService.getAllDrivers();
		assertThat(searchResults).hasSize(3);
	}

	@Test
	public void findBySearchTerm_FindByDriverId() {
		Driver searchResult = driverService.getDriver(2);
		assertThat(searchResult).isNotNull();
	}

	@Test
	public void findBySearchTerm_FindByDriverIdAndGetFieldValue() {
		Driver searchResult = driverService.getDriver(2);
		assertThat(searchResult.getFirstname()).isNotNull();
		assertThat(searchResult);
	}
	
	
	@Test
	public void findBySearchTerm_FindDepartmentNames() {
		List<Department> searchResults = departService.getAllDepartments();
		assertThat(searchResults).isNotNull();
	}
	

}
