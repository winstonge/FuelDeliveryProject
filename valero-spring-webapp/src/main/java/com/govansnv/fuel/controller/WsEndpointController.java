package com.govansnv.fuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.govansnv.fuel.model.FuelDelivery;

@Controller
@RequestMapping("wsendpoint")
public class WsEndpointController {

	@PostMapping("/addDelivery/{deviceId}")
	@ResponseBody
	public String handleFuelDeliveryRequest(@PathVariable("deviceId") int deviceId, @RequestBody FuelDelivery delivery) {		
		return "delivery registered from deviceId "+ deviceId;
	}
}
