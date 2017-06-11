package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.DeviceDao;
import com.govansnv.fuel.model.Device;

@Repository
public class DeviceDaoImpl extends AbstractDao<Integer, Device> implements DeviceDao {
	static Log log = LogFactory.getLog(DeviceDaoImpl.class.getName());
	
	@Transactional
	public Device create(Device device) {
		persist(device);
		return device;
	}

	public Device getDevice(int id) {
		try {
			Device device = (Device) getEntityManager().createQuery("SELECT d FROM Device d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();
			return device;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}
	
	public Device getDeviceByNo(int deviceNo) {
		try {
			Device device = (Device) getEntityManager().createQuery("SELECT d FROM Device d WHERE d.deviceNo = :deviceNo")
					.setParameter("deviceNo", deviceNo).getSingleResult();
			return device;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<Device> getAll() {
		List<Device> devices = getEntityManager().createQuery("SELECT d FROM Device d ORDER BY id ASC")
				.getResultList();
		return devices;
	}

	//Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updateDevice(Device device) {
		Device d = (Device) getEntityManager().createQuery("SELECT d FROM Device d WHERE d.id = :Id")
				.setParameter("Id", device.getId()).getSingleResult();
		if(d!=null){
			d.setDeviceNo(device.getDeviceNo());
			d.setLastSynch(device.getLastSynch());			
		}
		update(d);
	}
	
	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the Device data");
		Device device = getDevice(id);
		if(device!=null){
			delete(device);
			return true;
		}		
		return false;		
	}

	
}
