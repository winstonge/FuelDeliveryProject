package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Device;

public interface DeviceService {
	
	public List getAllDevices();
	
	public Device getDevice(int id);
	
	public Device getDeviceByNo(int deviceNo);
	
	public Device addDevice(Device device);
	
	public Device updateDevice(Device device);
	
	public boolean deleteDevice(int id);
}
