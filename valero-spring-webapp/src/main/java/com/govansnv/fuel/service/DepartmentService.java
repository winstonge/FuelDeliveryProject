package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Department;

public interface DepartmentService {
	
	public List getAllDepartments();
	
	public Department getDepartment(int id);
	
	public Department addDepartment(Department department);
	
	public Department updateDepartment(Department department);
	
	public boolean deleteDepartment(int id);
}
