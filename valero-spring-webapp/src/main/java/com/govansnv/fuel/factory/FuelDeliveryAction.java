package com.govansnv.fuel.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.controller.DeviceRestController;
import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.model.Device;
import com.govansnv.fuel.model.FuelDelivery;
import com.govansnv.fuel.model.Truck;
import com.govansnv.fuel.service.DeviceService;
import com.govansnv.fuel.service.FuelDeliveryService;
import com.govansnv.fuel.service.TruckService;

@Component
public class FuelDeliveryAction implements BasicFuelingAction {
	private FuelDelivery fuelDelivery;
	private static Log log = LogFactory.getLog(FuelDeliveryAction.class.getName());

	@Autowired
	DeviceService deviceService;
	@Autowired
	FuelDeliveryService fuelDeliveryService;
	@Autowired
	TruckService truckService;

	public StatusDTO performAction(String action, int deviceId, String truckNumber, Object fuelingObject) {
		this.fuelDelivery = (FuelDelivery) fuelingObject;		
		log.info("action :"+ action);
		
		// Get the device object
		Device device = deviceService.getDeviceByNo(deviceId); 
		// Get the truck object
		Truck truck = truckService.getTruckByNo(truckNumber);
		
		// Add references
		fuelDelivery.setDevice(device);
		fuelDelivery.setTruck(truck);
		// Create object
		FuelDelivery delivery = fuelDeliveryService.addFuelDelivery(fuelDelivery);
		// Return the StatusDTO
		StatusDTO dto = new StatusDTO();
		if (delivery.getId() > 0) {
			// Success
			dto.setMessage("Success");
			dto.setStatus(1);// Success
		} else {
			// Failed
			dto.setMessage("Failed");
			dto.setStatus(0);// Success
		}
		return dto;
	}
}
