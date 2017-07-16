package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.RefuelDao;
import com.govansnv.fuel.model.Refuel;

@Repository
public class RefuelDaoImpl extends AbstractDao<Integer, Refuel> implements RefuelDao {

	private static Log log = LogFactory.getLog(RefuelDaoImpl.class.getName());

	@Transactional
	public Refuel create(Refuel refuel) {
		try {
			persist(refuel);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return refuel;
	}

	public Refuel getRefuel(int id) {
		try {
			Refuel refuel = (Refuel) getEntityManager().createQuery("SELECT d FROM Refuel d WHERE d.id = :Id")
					.setParameter("Id", id).getSingleResult();
			return refuel;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<Refuel> getAll() {
		List<Refuel> refuels = getEntityManager().createQuery("SELECT d FROM Refuel d ORDER BY 1 ASC").getResultList();
		return refuels;
	}

	// Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public void updateRefuel(Refuel refuel) {
		Refuel ref = (Refuel) getEntityManager().createQuery("SELECT d FROM Refuel d WHERE d.id = :Id")
				.setParameter("Id", refuel.getId()).getSingleResult();
		if (ref != null) {
			ref.setGrossLiters(refuel.getGrossLiters());
			ref.setTankContent(refuel.getTankContent());
		}
		update(ref);
	}

	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the refuel data");
		Refuel refuel = getRefuel(id);
		if (refuel != null) {
			delete(refuel);
			return true;
		}
		return false;
	}
}
