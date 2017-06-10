package com.govansnv.fuel.dao;

import java.util.List;

import com.govansnv.fuel.model.Company;

public interface CompanyDao {
	// Create a record in the company table
		public Company create(Company company);

		// Retrieve a single object
		public Company getCompany(int id);

		// Retrieve all company objects from the table
		public List<Company> getAll();

		// Update driver object in company table
		public Company updateCompany(Company company);
		
		//Remove the item
		public boolean remove(int id);
}
