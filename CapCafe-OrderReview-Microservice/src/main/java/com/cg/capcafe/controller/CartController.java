package com.cg.capcafe.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Review;
import com.cg.capcafe.service.ICartService;
import com.cg.capcafe.service.IReviewService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/order")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	
	@Autowired
	IReviewService reviewService;
	
	//localhost:8882/getAllOrders/101
	@GetMapping(value="/getAllOrders/{empId}",produces= "application/json")
	List<Order> fetchOrderByEmployeeId(@PathVariable("empId") int empId) {
		return cartService.fetchOrderByEmployeeId(empId);
	}	

	//localhost:8882/addReview
	@PostMapping(value="/addNewOrder",consumes="application/json",produces="application/json")
	public Order addNewOrder(@RequestBody Order order) {
		return cartService.addNewOrder(order);
		
	}

	
	@PostMapping(value="/addReview")
	public Review addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
		
	}
	
	@GetMapping(value = "get-review-by-cafeid/{id}")
	public List<Review> getReviews(@PathVariable("id") int id){
		return reviewService.fetchReviewbycafeId(id);
	}

	@GetMapping(value = "add-money")
	public double addMoney(@RequestParam("money") double money, @RequestParam("id") int empId) {
		return cartService.addMoney(empId, money);
	}
	


	
}
