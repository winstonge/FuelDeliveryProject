package com.govansnv.fuel.service;

import java.util.List;

import com.govansnv.fuel.model.Company;

public interface CompanyService {
	
public List<Company> getAllCompanies();
	
	public Company getCompany(int id);
	
	public Company addCompany(Company company);
	
	public Company updateCompany(Company company);
	
	public boolean deleteCompany(int id);

}
