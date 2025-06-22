package com.springapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.springapp.entity.Company;
import com.springapp.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.entity.Job;
import com.springapp.repository.JobRepository;
import com.springapp.service.JobService;

@Service
public class JobServiceImpl2 implements JobService {

	@Autowired
	JobRepository jobRepository;

	@Autowired
	CompanyRepository compRepository;

	@Override
	public List<Job> getAllJobs() {
		List<Job> allJobs = jobRepository.findAll();
		return allJobs;
	}

	@Override
	public void createJob(Job job) {
		Company comp = compRepository.findById(job.getCompany().getId()).orElse(null);
		if(null != comp){
			job.setCompany(comp);
		}
        jobRepository.save(job);
	}

	@Override
	public Job findById(Long id) {
		Job job = jobRepository.findById(id).orElse(null);

		return job;
	}

	@Override
	public boolean deleteById(Long id) {

		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()){
			jobRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJob(Long id, Job job) {
		Optional<Job> optionalJob = jobRepository.findById(id);
		if (optionalJob.isPresent()) {
			Job j = optionalJob.get();
			j.setTitle(job.getTitle());
			j.setDescription(job.getDescription());
			j.setCurrentSalary(job.getCurrentSalary());
			j.setExpectedSalary(job.getExpectedSalary());
			j.setLocation(job.getLocation());
			jobRepository.save(j);
			return true;
		}

		return false;
	}

}
