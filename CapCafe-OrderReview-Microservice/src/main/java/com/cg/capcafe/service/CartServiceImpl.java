package com.cg.capcafe.service;

import java.time.LocalDateTime;
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
		return orders;
		
	}


	@Override
	public List<Order> getAllOrders() {
		return null;
	}


	@Override
	public Order addNewOrder(Order order) {
		double wallet = order.getEmployee().getWallet() - order.getTotalAmount();
		double account = order.getCafe().getAccount() + order.getTotalAmount();
		employeeReopository.deductWallet(wallet, order.getEmployee().getEmpId());
		caferepository.updateCafeAccount(account, order.getCafe().getCafeId());
		order.setTimestamp(LocalDateTime.now());
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


	@Override
	public double addMoney(int empid, double amount) {
		employeeReopository.updateWallet(amount, empid);
		return amount;
	}




	
	
	
	
	
	
	
	
	
	
	
}
