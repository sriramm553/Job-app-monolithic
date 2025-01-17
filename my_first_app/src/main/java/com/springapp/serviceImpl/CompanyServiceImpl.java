package com.springapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.entity.Company;
import com.springapp.repository.CompanyRepository;
import com.springapp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository compRepo;

	@Override
	public List<Company> getAllCompany() {
		List<Company> allCompany = compRepo.findAll();
		
		return allCompany;
	}

	@Override
	public void createCompany(Company company) {
		compRepo.save(company);
	}

	@Override
	public Company findById(Long id) {
		Company company = compRepo.findById(id).orElse(null);
		return company;
	}

	@Override
	public boolean deleteById(Long id) {
		
		if(compRepo.existsById(id)) {
			compRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCompany(Long id, Company company) {
		Optional<Company> compOptional = compRepo.findById(id);
		if(compOptional.isPresent()) {
			Company comp = compOptional.get();
			comp.setName(company.getName());
			comp.setDescription(company.getDescription());
			comp.setJob(company.getJob());
			compRepo.save(comp);
			return true;
		}
		return false;
	}

}
