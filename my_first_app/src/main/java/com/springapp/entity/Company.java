package com.springapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;

    private String description;

	@OneToMany(mappedBy = "company")//, fetch = FetchType.EAGER)
	@JsonManagedReference("company-jobs")
	private List<Job> job;

	// In Company.java
	@OneToMany(mappedBy = "company")
	@JsonManagedReference("company-reviews")
	private List<Review> review;

	public Company() {
	}

	public Company(Long id, String name, String description, List<Job> job, List<Review> review) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.job = job;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", job=" + job + "]";
	}

}
