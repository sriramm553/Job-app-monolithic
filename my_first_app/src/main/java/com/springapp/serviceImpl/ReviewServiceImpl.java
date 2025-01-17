package com.springapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.entity.Company;
import com.springapp.entity.Review;
import com.springapp.repository.CompanyRepository;
import com.springapp.repository.ReviewRepository;
import com.springapp.service.CompanyService;
import com.springapp.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private CompanyService compService;
	
	
	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> allReview = reviewRepo.findByCompanyId(companyId);
		return allReview;
	}

	@Override
	public boolean createReview(Long companyId, Review review) {
		Company company = compService.findById(companyId);
		if(null != company) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review findById(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews.stream()
				.filter(r -> r.getId().equals(reviewId))
				.findFirst().orElse(null);
	}

	@Override
	public boolean deleteById(Long companyId,Long reviewId){
		Review reviewItem = findById(companyId,reviewId);
		System.out.println(reviewItem+"-------------");
		if(null != reviewItem && reviewRepo.existsById(reviewItem.getId())) {
			reviewRepo.deleteById(reviewItem.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review review) {
		Review reviewItem = findById(companyId,reviewId);
		if(null != reviewItem) {
			reviewItem.setTitle(review.getTitle());
			reviewItem.setDescription(review.getDescription());
			reviewItem.setRating(review.getRating());
			reviewRepo.save(reviewItem);
			return true;			
		}
		return false;
	}

}
