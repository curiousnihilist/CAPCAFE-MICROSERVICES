package com.cg.capcafe.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Review;
import com.cg.capcafe.repository.CafeRepository;
import com.cg.capcafe.repository.EmployeeReopository;
import com.cg.capcafe.repository.ReviewRepository;


@Transactional
@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	EmployeeReopository employeeRepo;
	
	@Autowired
	CafeRepository cafeRepository;
	
	
	@Override
	public Review addReview(Review review) {
		Cafe cafe = cafeRepository.findById(review.getCafe().getCafeId()).get();
		double rating = (cafe.getAvgRating()+review.getRating())/2;
		cafeRepository.updateRating(rating, review.getCafe().getCafeId());
		 return reviewRepository.save(review);
	}
	
	@Override
	public List<Review> fetchReviewbycafeId(int cafeId) {
		List<Review> reviewByCafe =reviewRepository.findByCafeId(cafeId);
		return reviewByCafe;
		}
	
	@Override
	public List<Review> fetchReviewbyempId(int empId) {
		//List<Review> reviewByEmployee =reviewRepository.findByEmployeeId(empId);
		//System.out.println(reviewByEmployee);
		//return reviewByEmployee;
		return null;
	}

	
//	@Override
//	public Set<Review> fetchReviewbycafeId(int cafeId) {
//		Set<Review> reviewByCafe =reviewRepository.getReviewByCafeId(cafeId);
//		System.out.println(reviewByCafe);
//		return reviewByCafe;
//	}
//
//	@Override
//	public Set<Review> fetchReviewbyEmpId(int empId) {
//		Set<Review> reviewByEmployee =reviewRepository.getReviewByEmpId(empId);
//		System.out.println(reviewByEmployee);
//		return reviewByEmployee;
//	}
	

	

}
