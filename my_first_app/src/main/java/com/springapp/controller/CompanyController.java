package com.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.entity.Company;
import com.springapp.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	
	@Autowired
	CompanyService compService;
	
	@GetMapping
	public ResponseEntity<Company> getAllCompanies(){
		List<Company> allcompanies = compService.getAllCompany();
		return new ResponseEntity(allcompanies, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addCompanies(@RequestBody Company company){
		compService.createCompany(company);
		return new ResponseEntity<>("Company added Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable Long id) {
		
		Company comp = compService.findById(id);
		if(null != comp) {
			return new ResponseEntity<>(comp,HttpStatus.OK);
		}
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
		
		boolean deleted = compService.deleteById(id);
		if(deleted)	return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> addCompany(@PathVariable Long id,
										  @RequestBody Company company){
		boolean updated = compService.updateCompany(id,company);
		if(updated)	return new ResponseEntity<>("Jobs updated Successfully",HttpStatus.CREATED);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}
}
