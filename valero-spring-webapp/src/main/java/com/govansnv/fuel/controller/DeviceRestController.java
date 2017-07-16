package com.govansnv.fuel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.factory.ActionFactory;
import com.govansnv.fuel.factory.BasicFuelingAction;
import com.govansnv.fuel.model.Device;
import com.govansnv.fuel.model.Fuel;
import com.govansnv.fuel.model.FuelDelivery;
import com.govansnv.fuel.model.Refuel;
import com.govansnv.fuel.service.DeviceService;

@RestController
public class DeviceRestController {
	static Log log = LogFactory.getLog(DeviceRestController.class.getName());
	@Autowired
	DeviceService deviceService;
	@Autowired
	ActionFactory factory;
	
	@GetMapping("/devices")
	public List<Device> getDevices() {
		List<Device> list = deviceService.getAllDevices();
		return list;
	}
	
	@GetMapping(value = "/devices/{deviceid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Device getCompany(@PathVariable("deviceid") int deviceId) {
		Device device = deviceService.getDevice(deviceId);
		return device;
	}

	@PostMapping("/devices/fuel/{deviceid}/{truckno}")
	public StatusDTO postFuelDelivery(@PathVariable("deviceid") int deviceId,
			@PathVariable("truckno") String truckNumber, 
			@RequestBody FuelDelivery delivery) {
		StatusDTO dto = factoryMehtod(deviceId, truckNumber, ActionFactory.FUEL_TYPE, delivery);
		return dto;
	}	
	
	@PostMapping("/devices/refuel/{deviceid}/{truckno}")
	public StatusDTO postRefuelTankTruck(@PathVariable("deviceid") int deviceId,
			@PathVariable("truckno") String truckNumber, 
			@RequestBody Refuel delivery) {
		StatusDTO dto = factoryMehtod(deviceId, truckNumber, ActionFactory.REFUEL_TYPE, delivery);
		return dto;
	}
	
	private StatusDTO factoryMehtod(int deviceId, String truckNumber, String actionType, Object delivery) {
		BasicFuelingAction action = factory.getAction(actionType);
		StatusDTO dto=  action.performAction(actionType, deviceId, truckNumber, delivery);
		return dto;
	}
}
