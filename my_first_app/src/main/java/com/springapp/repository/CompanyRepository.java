package com.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springapp.entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

}
