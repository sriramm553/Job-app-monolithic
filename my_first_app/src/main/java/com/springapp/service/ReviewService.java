package com.springapp.service;

import java.util.List;

import com.springapp.entity.Review;

public interface ReviewService {
	
	public List<Review> getAllReviews(Long companyId);
	
	public boolean createReview(Long companyId, Review review);

	public Review findById(Long companyId,Long reviewId);

	public boolean deleteById(Long companyId,Long reviewId);

	public boolean updateReview(Long companyId, Long reviewId, Review review);

}
