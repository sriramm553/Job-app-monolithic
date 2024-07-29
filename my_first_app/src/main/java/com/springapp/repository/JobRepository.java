package com.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springapp.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

}
