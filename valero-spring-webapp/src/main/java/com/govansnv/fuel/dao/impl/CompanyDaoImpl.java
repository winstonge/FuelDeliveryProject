package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.CompanyDao;
import com.govansnv.fuel.model.Company;

@Repository
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements CompanyDao {

	static Log log = LogFactory.getLog(DriverDaoImpl.class.getName());

	@Transactional
	public Company create(Company company) {
		try{
			persist(company);
		}catch(Exception e){
			log.error(e);
		}		
		return company;
	}

	@Transactional
	public Company getCompany(int id) {
		try {
			Company company = (Company) getEntityManager().createQuery("SELECT d FROM Company d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();

			return company;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	@Transactional
	public List<Company> getAll() {
		List<Company> drivers = getEntityManager().createQuery("SELECT d FROM Company d  ORDER BY d.company_name ASC")
				.getResultList();
		return drivers;
	}

	// Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public Company updateCompany(Company company) {
		Company c=null;
		try{
			c = (Company) getEntityManager().createQuery("SELECT d FROM Company d WHERE d.id = :Id")
					.setParameter("Id", company).getSingleResult();
			if (company != null) {
				c.setCompanyName(company.getCompanyName());
				c.setPhone(company.getPhone());
				c.setFax(company.getFax());
				c.setAddres(company.getAddres());
				c.setCity(company.getCity());
				c.setPostalCode(company.getPostalCode());
				c.setSlogan(company.getSlogan());
			}
			update(c);
		}catch(Exception e ){
			log.error(e);
		}		
		return c;
	}

	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the company data");
		try{
			Company company = getCompany(id);
			if (company!= null) {
				delete(company);
				return true;
			}
		}catch(Exception e){
			log.error(e);
		}		
		return false;
	}

}
