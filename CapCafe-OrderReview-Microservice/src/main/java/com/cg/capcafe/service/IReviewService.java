package com.cg.capcafe.service;

import java.util.List;
import java.util.Set;

import com.cg.capcafe.dto.Review;


public interface IReviewService {
	

	 Review addReview(Review review);
	 
	 List<Review> fetchReviewbycafeId(int cId);
	 

	 List<Review> fetchReviewbyempId(int eId);
}
