package com.govansnv.fuel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.govansnv.fuel.dto.StatusDTO;
import com.govansnv.fuel.model.Company;
import com.govansnv.fuel.model.Department;
import com.govansnv.fuel.service.DepartmentService;

@RestController
public class DepartmentRestController {
	
	static Log log = LogFactory.getLog(DepartmentRestController.class.getName());

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getCompanies() {
		List<Department> list = departmentService.getAllDepartments();
		return list;
	}

	@GetMapping(value = "/departments/{departmentId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Department getDepartment(@PathVariable("departmentId") int departmentId) {
		Department department = departmentService.getDepartment(departmentId);
		return department;
	}

	@RequestMapping(value = "/departments/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Department addDepartment(@RequestBody Department department) {
		log.info("Going to create a new company");
		Department dep = departmentService.addDepartment(department);
		return dep;
	}

	@RequestMapping(value = "/departments/update", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Department updateDepartment(@RequestBody Department department) {
		log.info("Going to update a company information");
		Department dep = departmentService.updateDepartment(department);
		return dep;
	}
	
	
	
}
