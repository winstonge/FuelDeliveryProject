package com.govansnv.fuel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.govansnv.fuel.dao.CompanyDao;
import com.govansnv.fuel.model.Company;
import com.govansnv.fuel.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;

	public List<Company> getAllCompanies() {
		return companyDao.getAll();
	}

	public Company getCompany(int id) {
		return companyDao.getCompany(id);
	}

	public Company addCompany(Company company) {
		Company comp=null;
		try {
			comp = companyDao.create(company);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comp;
	}

	public Company updateCompany(Company company) {
		Company comp = companyDao.updateCompany(company);
		return comp;
	}

	public boolean deleteCompany(int id) {
		return companyDao.remove(id);
	}

}
