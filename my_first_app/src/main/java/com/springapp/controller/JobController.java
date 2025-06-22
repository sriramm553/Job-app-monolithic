package com.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.springapp.entity.Job;
import com.springapp.service.JobService;

import javax.validation.Valid;


@RestController
@RequestMapping("/jobs")
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping
	public ResponseEntity<Job> getAllJobs(){
		List<Job> allJobs = jobService.getAllJobs();
		System.out.println("Job Service Called ************");
		return new ResponseEntity(allJobs, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addJobs(@RequestBody @Valid Job job, BindingResult result){

		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getAllErrors().toString());
		}
		jobService.createJob(job);
		return new ResponseEntity<>("Job added Successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/retrieveById")
	public ResponseEntity<Job> getJob(@RequestParam Long id) {
		
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
