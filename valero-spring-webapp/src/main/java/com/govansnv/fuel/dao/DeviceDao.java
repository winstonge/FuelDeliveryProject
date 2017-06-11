package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Device;

public interface DeviceDao {

	// Create a record in the device table
	public Device create(Device driver);

	// Retrieve a single object
	public Device getDevice(int id);
	
	// Retrieve a single object by device number
	public Device getDeviceByNo(int deviceNo);

	// Retrieve all device objects from the table
	public List<Device> getAll();

	// Update device object in device table
	public void updateDevice(Device device);
	
	//Remove the item
	public boolean remove(int id);
}
