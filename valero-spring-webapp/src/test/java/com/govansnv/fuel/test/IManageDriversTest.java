package com.govansnv.fuel.test;

import static org.junit.Assert.assertNotNull;

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
import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.govansnv.fuel.config.AppConfig;
import com.govansnv.fuel.service.DriverService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetups({
		// Cleanup DB
		@DatabaseSetup(value = "classpath:truck-entries-clean.xml"),
		@DatabaseSetup(value = "classpath:driver-entries-clean.xml"),
		@DatabaseSetup(value = "classpath:device-entries-clean.xml"),
		@DatabaseSetup(value = "classpath:department-entries-clean.xml"),
		@DatabaseSetup(value = "classpath:customer-entries-clean.xml"),
		// Insert into DB
		@DatabaseSetup(value = "classpath:company-entries.xml"),
		@DatabaseSetup(value = "classpath:department-entries.xml"),
		@DatabaseSetup(value = "classpath:driver-entries.xml") })
@WebAppConfiguration
public class IManageDriversTest {

	@Autowired
	DriverService driverService;

	@Test
	public void findBySearchTerm_FindAll() {
		List<?> searchResults = driverService.getAllDrivers();
		assertNotNull(searchResults);
	}
}
