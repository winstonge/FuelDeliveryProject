package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.CustomerDao;
import com.govansnv.fuel.model.Customer;
import com.govansnv.fuel.model.Department;

@Repository
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

	static Log log = LogFactory.getLog(CustomerDaoImpl.class.getName());

	@Transactional
	public Customer create(Customer customer){
		try{
			persist(customer);			
		}catch(Exception e){
			log.error(e);
		}
		return customer;
	}

	@Transactional
	public Customer getCustomer(int id) {
		try {
			Customer customer = (Customer) getEntityManager()
					.createQuery("SELECT d FROM Customer d WHERE d.id = :Id").setParameter("Id", id)
					.getSingleResult();

			return customer;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	@Transactional
	public List<Customer> getAll() {
		List<Customer> customer = getEntityManager().createQuery("SELECT d FROM Customer d  ORDER BY 1 ASC")
				.getResultList();
		return customer;
	}

	// Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer d =null;
		try{
			d = (Customer) getEntityManager().createQuery("SELECT d FROM Customer d WHERE d.id = :Id")
					.setParameter("Id", customer.getId()).getSingleResult();
			if (d != null) {
				d.setCustomerId(customer.getCustomerId());
				d.setCustomerShipTo(customer.getCustomerShipTo());
				d.setCustomerSoldTo(customer.getCustomerSoldTo());
				d.setShipTo(customer.getShipTo());
				d.setBarcode(customer.getBarcode());
			}
			update(d);
		}catch(Exception e){
			log.error(e);
		}		
		return d;
	}

	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the customer data");
		try{
			Customer customer = getCustomer(id);
			if (customer != null) {
				delete(customer);
				return true;
			}
		}catch(Exception e){
			log.error(e);
		}		
		return false;
	}

}
