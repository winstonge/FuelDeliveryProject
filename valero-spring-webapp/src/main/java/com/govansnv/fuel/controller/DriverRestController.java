package com.govansnv.fuel.controller;

import java.util.List;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.model.Driver;
import com.govansnv.fuel.service.DriverService;


@RestController
public class DriverRestController {
	static Log log = LogFactory.getLog(DriverRestController.class.getName());

	@Autowired
	DriverService driverService;

	@GetMapping("/drivers")
	public List<Driver> getDrivers() {
		List<Driver> list = driverService.getAllDrivers();
		return list;
	}

	@GetMapping(value = "/drivers/{driverId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Driver getDriver(@PathVariable("driverId") int driverId) {
		Driver driver = driverService.getDriver(driverId);
		return driver;
	}

	@RequestMapping(value = "/drivers/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Driver addDriver(@RequestBody Driver driver) {
		log.info("Going to create a new driver");
		driver = driverService.addDriver(driver);
		return driver;
	}

	@RequestMapping(value = "/drivers/update", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Driver updateDriver(@RequestBody Driver driver) {
		log.info("Going to update a driver information");
		driver = driverService.updateDriver(driver);
		return driver;
	}

	
}
