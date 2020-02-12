package com.cg.capcafe.service;

import java.util.List;
import java.util.Set;

import com.cg.capcafe.dto.Employee;
//import ;
import com.cg.capcafe.dto.Order;

public interface ICartService {
	
	
//Fetch order by employeeId
	List<Order> fetchOrderByEmployeeId(int empId);
	
//	get all orders;
	List<Order> getAllOrders();
	
	
//	add new order
	Order addNewOrder(Order order);
	
//	get order by orderId
	Order getById(int orderId);
	
//getOrderByLocation
	List<Order> getOrdersByLocation(String location);
	
	double addMoney(int empid, double amount);


}
