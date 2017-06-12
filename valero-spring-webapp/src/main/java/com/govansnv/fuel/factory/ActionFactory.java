package com.govansnv.fuel.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionFactory {
	private final String FUEL_TYPE="fuel";
	private final String REFUEL_TYPE="refuel";
	private static Log log = LogFactory.getLog(ActionFactory.class.getName());
	
	@Autowired
	FuelDeliveryAction fuelDeliveryAction;
	@Autowired
	FuelDeliveryAction refuelAction;
	
	public BasicFuelingAction getAction(String actionType) {
		if (actionType == null) {
			return null;
		}

		if (actionType.equalsIgnoreCase(FUEL_TYPE)) {
			return fuelDeliveryAction;
		}else if(actionType.equalsIgnoreCase(REFUEL_TYPE)) {
			return refuelAction;
		}
		return null;
	}
}
