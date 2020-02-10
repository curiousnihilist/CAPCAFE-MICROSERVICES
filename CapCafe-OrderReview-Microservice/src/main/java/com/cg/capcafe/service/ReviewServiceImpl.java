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
//		System.out.println(review);
//		 Cafe cafe = cafeRepository.findById(review.getCafeId()).get();
//		 cafe.getReviews().add(review);
//		 cafeRepository.save(cafe);
//		 System.out.println("==============");
//		 System.out.println(employeeRepo.existsById(review.getEmployee()));
//		 System.out.println("================");
//		 Employee emp = employeeRepo.findById(review.getEmployee()).get();
//		 System.out.println("==================");
//		 emp.getPastReviews().add(review);
//		 System.out.println("==================");
//		 employeeRepo.save(emp);
		 return reviewRepository.save(review);
	}
	
	@Override
	public List<Review> fetchReviewbycafeId(int cafeId) {
//		List<Review> reviewByCafe =reviewRepository.findByCafeId(cafeId);
//		System.out.println(reviewByCafe);
//		return reviewByCafe;
		return null;
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
