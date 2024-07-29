package com.springapp.service;

import java.util.List;

import com.springapp.entity.Job;

public interface JobService {
	
	public List<Job> getAllJobs();
	
	public void createJob(Job job);

	public Job findById(Long id);

	public boolean deleteById(Long id);

	public boolean updateJob(Long id, Job job);
	
	
	
}
