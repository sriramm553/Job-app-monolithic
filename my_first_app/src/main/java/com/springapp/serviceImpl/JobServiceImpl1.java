package com.springapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.entity.Job;
import com.springapp.repository.JobRepository;
import com.springapp.service.JobService;

//Without Repository

//@Service
public class JobServiceImpl1 implements JobService{
	


	List<Job> jobs = new ArrayList<>();
	
	@Override
	public List<Job> getAllJobs() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		
		jobs.add(job);
		
	}

	@Override
	public Job findById(Long id) {
		Optional<Job> job = jobs.stream().filter(i->i.getId()==id).findFirst();
		if(job.isPresent()) {
			return job.get();
		}
		System.out.println(job);
		return null;
		
	}

	@Override
	public boolean deleteById(Long id) {
		Optional<Job> job = jobs.stream().filter(i->i.getId()==id).findAny();
		if(job.isPresent()) {
			return jobs.remove(job.get());
		}
		return false;
	}

	@Override
	public boolean updateJob(Long id, Job job) {

		Optional<Job> job1 = jobs.stream().filter(i -> i.getId()==id).findAny();
		if(job1.isPresent()) {
			job1.stream().forEach(
					(j)->{
						j.setTitle(job.getTitle());
						j.setDescription(job.getDescription());
						j.setCurrentSalary(job.getCurrentSalary());
						j.setExpectedSalary(job.getExpectedSalary());
						j.setLocation(job.getLocation());
					});
			return true;
		}
				
		return false;
	}
	

}
