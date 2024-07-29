package com.springapp.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.entity.Job;
import com.springapp.service.JobService;


@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping
	public ResponseEntity<Job> getAllJobs(){
		List<Job> allJobs = jobService.getAllJobs();
		return new ResponseEntity(allJobs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addJobs(@RequestBody Job job){
		jobService.createJob(job);
		return new ResponseEntity<>("Job added Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJob(@PathVariable Long id) {
		
		Job job = jobService.findById(id);
		if(job != null) {
			return new ResponseEntity<>(job,HttpStatus.OK);
		}
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Job> deleteJob(@PathVariable Long id) {
		
		boolean deleted = jobService.deleteById(id);
		if(deleted)	return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	//@RequestMapping(value="/jobs/{id}",method = RequestMethod.PUT)
	public ResponseEntity<String> addJobs(@PathVariable Long id,
										  @RequestBody Job job){
		boolean updated = jobService.updateJob(id,job);
		if(updated)	return new ResponseEntity<>("Jobs updated Successfully",HttpStatus.CREATED);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}

}
