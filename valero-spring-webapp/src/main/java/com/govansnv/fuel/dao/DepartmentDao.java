package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Department;

public interface DepartmentDao {

	// Create a record in the department table
	public Department create(Department department);

	// Retrieve a single object
	public Department getDepartment(int id);

	// Retrieve all department objects from the table
	public List<Department> getAll(); 

	// Update driver object in department table
	public Department updateDepartment(Department department);
	
	//Remove the item
	public boolean remove(int id);
}
