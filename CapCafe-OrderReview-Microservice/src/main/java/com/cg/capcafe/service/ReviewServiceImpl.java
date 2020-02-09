package com.cg.capcafe.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Review;
import com.cg.capcafe.repository.EmployeeReopository;
import com.cg.capcafe.repository.ReviewRepository;


@Transactional
@Service
public class ReviewServiceImpl implements IReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	EmployeeReopository employeeRepo;
	@Override
	public Review addReview(Review review) {
		//review.setEmployee(104);
//		System.err.println(review);
//		Employee employee=employeeRepo.findById(review.getEmployee()).get();
//		System.err.println(employee);
//		Set<Review> reviewsSet=employee.getPastReviews();
//		reviewsSet.add(review);
//		employee.setPastReviews(reviewsSet);
//		System.out.println(review);
//		System.err.println(employee);
//		 employeeRepo.save(employee);
		reviewRepository.save(review);
		 return review;
	}
	@Override
	public List<Review> fetchReviewbycafeId(int cafeId) {
		List<Review> reviewByCafe =reviewRepository.findByCafeId(cafeId);
		System.out.println(reviewByCafe);
		return reviewByCafe;	
		}
	@Override
	public List<Review> fetchReviewbyempId(int empId) {
		List<Review> reviewByEmployee =reviewRepository.findByEmployeeId(empId);
		System.out.println(reviewByEmployee);
		return reviewByEmployee;
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
