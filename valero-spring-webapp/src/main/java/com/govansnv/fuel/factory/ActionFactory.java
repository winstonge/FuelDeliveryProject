package com.govansnv.fuel.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionFactory {
	public static final String FUEL_TYPE="fuel";
	public static final String REFUEL_TYPE="refuel";
		
	@Autowired
	FuelDeliveryAction fuelDeliveryAction;
	@Autowired
	RefuelingAction refuelAction;
	
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
