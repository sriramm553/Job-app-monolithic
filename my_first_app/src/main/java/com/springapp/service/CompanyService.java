package com.springapp.service;

import java.util.List;

import com.springapp.entity.Company;

public interface CompanyService {

	public List<Company> getAllCompany();

	public void createCompany(Company company);

	public Company findById(Long id);

	public boolean deleteById(Long id);

	public boolean updateCompany(Long id, Company company);

}
