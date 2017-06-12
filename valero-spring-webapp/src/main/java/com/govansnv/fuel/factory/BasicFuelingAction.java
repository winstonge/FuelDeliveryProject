package com.govansnv.fuel.factory;

import org.springframework.stereotype.Component;

import com.govansnv.fuel.dto.StatusDTO;

@Component
public interface BasicFuelingAction {
	
	public StatusDTO  performAction(String action, int deviceId, String truckNumber, Object fuelingObject);
	
}
