package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.DeviceDao;
import com.govansnv.fuel.model.Device;
import com.govansnv.fuel.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceDao deviceDao;

	public List getAllDevices() {
		return deviceDao.getAll();
	}

	public Device getDevice(int id) {
		return deviceDao.getDevice(id);
	}

	public Device addDevice(Device device) {
		Device d = deviceDao.create(device);
		return d;
	}

	public Device updateDevice(Device device) {
		deviceDao.updateDevice(device);
		return device;
	}

	public boolean deleteDevice(int id) {
		return deviceDao.remove(id);
	}

	public Device getDeviceByNo(int deviceNo) {
		return deviceDao.getDeviceByNo(deviceNo);
	}

}
