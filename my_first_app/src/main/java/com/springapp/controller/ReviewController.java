package com.springapp.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springapp.entity.Review;
import com.springapp.service.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<Review> getAllReview(@PathVariable Long companyId){
		List<Review> allReviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity(allReviews, HttpStatus.OK);
	}
	 
	@PostMapping("/reviews")
	public ResponseEntity<String> addReviews(@PathVariable Long companyId,
											 @RequestBody Review review){
		boolean isAdded = reviewService.createReview(companyId,review);
		if(isAdded) return new ResponseEntity<>("Review added Successfully",HttpStatus.CREATED);
		
		 return new ResponseEntity<>("Review Not Added",HttpStatus.NOT_FOUND);
	} 
	
	@GetMapping("reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId,
											@PathVariable Long reviewId ) {
		
		Review review = reviewService.findById(companyId,reviewId);
		if(review != null) {
			return new ResponseEntity<>(review,HttpStatus.OK);
		}
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("reviews/{reviewId}")
	public ResponseEntity<Review> deleteReview(@PathVariable Long companyId,
											@PathVariable Long reviewId) {
		
		boolean deleted = reviewService.deleteById(companyId,reviewId);
		if(deleted)	return new ResponseEntity("Deleted Successfully",HttpStatus.OK);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("reviews/{reviewId}")
	public ResponseEntity<String> updateReviews(@PathVariable Long companyId,
												@PathVariable Long reviewId,
												@RequestBody Review review){
		boolean updated = reviewService.updateReview(companyId, reviewId, review);
		if(updated)	return new ResponseEntity<>("Review updated Successfully",HttpStatus.CREATED);
		
		return new ResponseEntity("ID Not Found",HttpStatus.NOT_FOUND);
	}


}
