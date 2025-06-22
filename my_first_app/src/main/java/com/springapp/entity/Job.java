package com.springapp.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Table(name = "jobs_table")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String title;

    private String description;

    private String currentSalary;

    private String expectedSalary;

    private String location;

    @ManyToOne//(fetch = FetchType.EAGER)
    //@JsonIgnoreProperties("job")
    @JsonBackReference("company-jobs")
    private Company company;

    public Job() {
    }

    public Job(String title, Long id, String description, String currentSalary, String expectedSalary, String location, Company company) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.currentSalary = currentSalary;
        this.expectedSalary = expectedSalary;
        this.location = location;
        this.company = company;
    }

    @JsonCreator
    public Job(@JsonProperty("companyId") Long companyId) {
        this.company = new Company();
        this.company.setId(companyId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(String expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
	public String toString() {
		return "Jobs [id=" + id + ", title=" + title + ", description=" + description + ", currentSalary="
				+ currentSalary + ", expectedSalary=" + expectedSalary + ", location=" + location + "]";
	}

}
