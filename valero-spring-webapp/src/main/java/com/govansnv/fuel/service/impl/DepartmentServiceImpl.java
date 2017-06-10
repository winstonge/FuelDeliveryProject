package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.DepartmentDao;
import com.govansnv.fuel.model.Department;
import com.govansnv.fuel.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;

	public List getAllDepartments() {
		return departmentDao.getAll();
	}

	public Department getDepartment(int id) {
		return departmentDao.getDepartment(id);
	}

	public Department addDepartment(Department department) {
		Department dep = departmentDao.create(department);
		return dep;
	}

	public Department updateDepartment(Department department) {
		Department dep = departmentDao.updateDepartment(department);
		return dep;
	}

	public boolean deleteDepartment(int id) {
		return departmentDao.remove(id);
	}

}
