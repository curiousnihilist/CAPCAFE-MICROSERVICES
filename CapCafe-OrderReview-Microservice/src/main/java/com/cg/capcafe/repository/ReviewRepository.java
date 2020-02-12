package com.cg.capcafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	@Query("SELECT r FROM Review r JOIN FETCH r.cafe e WHERE e.cafeId=?1")
	List<Review> findByCafeId(int cafeId);
//	
//	
//	//@Query("SELECT r FROM Review r JOIN FETCH r.cafe e WHERE e.employeeId=:empId")
//	List<Review> findByEmployeeId(int empId);
}
