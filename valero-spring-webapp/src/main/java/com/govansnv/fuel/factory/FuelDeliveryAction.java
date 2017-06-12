package com.govansnv.fuel.factory;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.model.Device;
import com.govansnv.fuel.model.FuelDelivery;
import com.govansnv.fuel.model.Truck;
import com.govansnv.fuel.service.DeviceService;
import com.govansnv.fuel.service.FuelDeliveryService;
import com.govansnv.fuel.service.TruckService;
import com.govansnv.fuel.util.Constants;

@Component
public class FuelDeliveryAction implements BasicFuelingAction {
	
	private static Log log = LogFactory.getLog(FuelDeliveryAction.class.getName());
	private FuelDelivery fuelDelivery;
	@Autowired
	DeviceService deviceService;
	@Autowired
	FuelDeliveryService fuelDeliveryService;
	@Autowired
	TruckService truckService;

	public StatusDTO performAction(String action, int deviceId, String truckNumber, Object fuelingObject) {
		this.fuelDelivery = (FuelDelivery) fuelingObject;
		StatusDTO dto = null;
		log.info("action :" + action);
		try {
			// Get the device object
			Device device = deviceService.getDeviceByNo(deviceId);
			// Get the truck object
			Truck truck = truckService.getTruckByNo(truckNumber);

			// Create object
			Calendar today = Calendar.getInstance();
			Timestamp now = new Timestamp(today.getTimeInMillis()); 
			fuelDelivery.setDateadded(now);
			fuelDelivery.setDevice(device);
			fuelDelivery.setTruck(truck);
			FuelDelivery delivery = fuelDeliveryService.addFuelDelivery(fuelDelivery);
			
			// Return the StatusDTO
			dto = new StatusDTO();
			if (delivery.getId() > 0) {
				// Success
				dto.setMessage(Constants.SUCCESS);
				dto.setStatus(1);// Success
			} else {
				// Failed
				dto.setMessage(Constants.FAILED);
				dto.setStatus(0);// Failed
			}
		} catch (Exception e) {
			// Return the StatusDTO
			dto = new StatusDTO();
			dto.setMessage(Constants.ERROR);
			dto.setErrorMessage(e.getMessage());
			dto.setStatus(0);// Failed
		}
		return dto;
	}
}
