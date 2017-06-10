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
import com.govansnv.fuel.service.CompanyService;

@RestController
public class CompanyRestController {
	
	static Log log = LogFactory.getLog(CompanyRestController.class.getName());

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/companies")
	public List<Company> getCompanies() {
		List<Company> list = companyService.getAllCompanies();
		return list;
	}

	@GetMapping(value = "/companies/{companyId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Company getCompany(@PathVariable("companyId") int companyId) {
		Company company = companyService.getCompany(companyId);
		return company;
	}

	@RequestMapping(value = "/companies/add", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Company addCompany(@RequestBody Company company) {
		log.info("Going to create a new company");
		Company comp = companyService.addCompany(company);
		return comp;
	}

	@RequestMapping(value = "/companies/update", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Company updateCompany(@RequestBody Company company) {
		log.info("Going to update a company information");
		Company comp = companyService.updateCompany(company);
		return comp;
	}
	
}
