package com.springapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> job;

	@OneToMany(mappedBy = "company")
	private List<Review> review;

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Company() {
		super();
	}

	public Company(String name, String description, List<Job> job) {
		super();
		this.name = name;
		this.description = description;
		this.job = job;
	}

	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", description=" + description + ", job=" + job + "]";
	}

}
