package com.cg.capcafe.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.repository.CafeRepository;
import com.cg.capcafe.repository.EmployeeReopository;
import com.cg.capcafe.repository.OrderRepository;


@Transactional
@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
    EmployeeReopository employeeReopository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CafeRepository caferepository;


	@Override
	public List<Order> fetchOrderByEmployeeId(int empId) {
		List<Order> orders=orderRepository.getByEmpId(empId);
		System.out.println(orders);
		
		return orders;

		//List<Order> orders =emp.getPastOrders();
		//System.out.println(emp.getPastOrders());
		//return orders;
		//Employee emp=employeeReopository.findById(employee.getEmpId()).get();
		//List<Order> order=emp.getPastOrders();
		
	}


	@Override
	public List<Order> getAllOrders() {
		return null;
	}


	@Override
	public Order addNewOrder(Order order) {
		return orderRepository.save(order);
	}


	@Override
	public Order getById(int orderId) {
		return null;
	}


	@Override
	public List<Order> getOrdersByLocation(String location) {
		return null;
	}


//	@Override
//	public List<Order> getOrdersByLocation(String location) {
//		List<Order> orders=orderRepository.getByLocation(location);
//		System.out.println(orders);
//		
//		return orders;
//	}

	
	
	
	
	
	
	
	
	
	
	
}
