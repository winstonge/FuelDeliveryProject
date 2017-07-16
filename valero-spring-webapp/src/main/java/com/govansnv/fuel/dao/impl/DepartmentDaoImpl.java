package com.govansnv.fuel.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.govansnv.fuel.dao.AbstractDao;
import com.govansnv.fuel.dao.DepartmentDao;
import com.govansnv.fuel.model.Department;

@Repository
public class DepartmentDaoImpl extends AbstractDao<Integer, Department> implements DepartmentDao {

	private static Log log = LogFactory.getLog(DepartmentDaoImpl.class.getName());

	@Transactional
	public Department create(Department department) {
		try {
			persist(department);
		} catch (Exception e) {
			log.error(e);
		}
		return department;
	}

	public Department getDepartment(int id) {
		try {
			Department department = (Department) getEntityManager()
					.createQuery("SELECT d FROM Department d WHERE d.id = :Id").setParameter("Id", id)
					.getSingleResult();

			return department;
		} catch (NoResultException ex) {
			log.error(ex);
			return null;
		}
	}

	public List<Department> getAll() {
		List<Department> department = getEntityManager().createQuery("SELECT d FROM Department d  ORDER BY 1 ASC")
				.getResultList();
		return department;
	}

	// Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}

	@Transactional
	public Department updateDepartment(Department department) {
		Department d = (Department) getEntityManager().createQuery("SELECT d FROM Department d WHERE d.id = :Id")
				.setParameter("Id", department.getId()).getSingleResult();
		if (d != null) {
			d.setDepartmentName(department.getDepartmentName());
		}
		update(d);
		return d;
	}

	@Transactional
	public boolean remove(int id) {
		log.info("Going to delete the department data");
		Department department = getDepartment(id);
		if (department != null) {
			delete(department);
			return true;
		}
		return false;
	}

}
