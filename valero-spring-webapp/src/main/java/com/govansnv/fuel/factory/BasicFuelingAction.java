package com.govansnv.fuel.factory;

import com.govansnv.fuel.dto.StatusDTO;

public interface BasicFuelingAction {
	
	public StatusDTO  performAction(String action, int deviceId, String truckNumber, Object fuelingObject);
	
}
