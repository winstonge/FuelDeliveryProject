package com.govansnv.fuel.factory;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.model.Device;
import com.govansnv.fuel.model.FuelDelivery;
import com.govansnv.fuel.model.Refuel;
import com.govansnv.fuel.model.Truck;
import com.govansnv.fuel.service.DeviceService;
import com.govansnv.fuel.service.RefuelService;
import com.govansnv.fuel.service.TruckService;
import com.govansnv.fuel.util.Constants;

public class RefuelingAction implements BasicFuelingAction {
	private static Log log = LogFactory.getLog(RefuelingAction.class.getName());
	private Refuel refuel;
	
	@Autowired
	DeviceService deviceService;
	@Autowired
	RefuelService refuelService;
	@Autowired
	TruckService truckService;
	
	public StatusDTO performAction(String action, int deviceId, String truckNumber, Object fuelingObject) {
		this.refuel = (Refuel) fuelingObject;
		StatusDTO dto = null;
		log.info("action :" + action);
		try {
			// Get the device object
			Device device = deviceService.getDeviceByNo(deviceId);
			// Get the truck object
			Truck truck = truckService.getTruckByNo(truckNumber);

			// Add references
			refuel.setDevice(device);
			refuel.setTruck(truck);
			// Create object
			Calendar today = Calendar.getInstance();
			Timestamp now = new Timestamp(today.getTimeInMillis()); 
			refuel.setDateadded(now);
			Refuel rf = refuelService.addRefuel(refuel);
			// Return the StatusDTO
			dto = new StatusDTO();
			if (rf.getId() > 0) {
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
