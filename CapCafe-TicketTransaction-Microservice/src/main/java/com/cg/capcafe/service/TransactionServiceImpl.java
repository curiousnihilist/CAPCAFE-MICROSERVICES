package com.cg.capcafe.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Transaction;
import com.cg.capcafe.exception.EmployeeNotFoundException;
import com.cg.capcafe.repository.EmployeeRepository;
import com.cg.capcafe.repository.OrderRepository;
import com.cg.capcafe.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService 
{
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public double payment(Order order, Employee employee) 
	{
		Cafe cafe = new Cafe();
		FoodItem foodItem = new FoodItem();
		Employee emp = employeeRepository.findById(employee.getEmpId()).get();
		if(emp != null)
		{
			
			String emp_name =	emp.getName();
			String emp_email = emp.getEmail();
			
			
			double walletAmount = employee.getWallet(); //wallet Amount
			double orderAmount = order.getTotalAmount();	// Order Amount
		
			List<FoodItem> food = order.getCart();
			//
//				double orderAmountFood = food.stream().map(orderAmount -> foodItem.getPrice() + );
				
			//
			walletAmount = walletAmount - orderAmount;
			employee.setWallet(walletAmount);//employee
			order.setTotalAmount(orderAmount);
			
			
			Transaction transaction = new Transaction();
			transaction.setOrder(order);
			transaction.setTimestamp(LocalDateTime.now());
			transaction.setPaymentMode("Card");
			
			 transactionRepository.save(transaction);
			 return orderAmount;
		}
		else
		{
			throw new EmployeeNotFoundException("Employee not Found");
		}
		
		
	}
	
}
