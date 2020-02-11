package com.cg.capcafe.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Transaction;
import com.cg.capcafe.exception.EmployeeNotFoundException;
import com.cg.capcafe.exception.TransactionNotFoundException;
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
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public double  getTotalAmount(Transaction transaction) throws TransactionNotFoundException
	{
		double total_amt = 0;
		
		double wallet;
		 
		int empId  = transaction.getOrder().getEmployee().getEmpId();
		
		int cafeId = transaction.getOrder().getCafe().getCafeId();
		
		 double totalAmount = transaction.getOrder().getTotalAmount();
		
		 wallet = transaction.getOrder().getEmployee().getWallet();
		 
		 if(wallet <= 0)
		 {
			 throw new EmployeeNotFoundException("Insuffiecient Amount");
		 }
		 else if(wallet < totalAmount)
		 {
			 throw new EmployeeNotFoundException("Insuffiecient Amount");
		 }
		 else if(wallet > totalAmount)
		 {
		 
			 total_amt = wallet - totalAmount;
		
			 Employee employee = transaction.getOrder().getEmployee();	// employee
			 employee.setWallet(wallet);								// update the wallet amount in employee
			 employeeRepository.save(employee);							//update
		
		 }
		 
		 return total_amt;
		/*
		 * Order order = new Order(); Employee emp =
		 * employeeRepository.findById(employee.getEmpId()).get();
		 * System.out.println(emp);
		 * 
		 * if(emp == null) { throw new EmployeeNotFoundException("Employee not Found");
		 * } else {
		 * 
		 * for (Order orders : emp.getPastOrders()) { total_amt = total_amt +
		 * orders.getTotalAmount(); }
		 * 
		 * double walletAmount = employee.getWallet(); //wallet Amount double
		 * orderAmount = total_amt; // Order Amount
		 * 
		 * walletAmount = walletAmount - orderAmount;
		 * employee.setWallet(walletAmount);//employee
		 * order.setTotalAmount(orderAmount);
		 * 
		 * 
		 * Transaction transaction = new Transaction(); transaction.setOrder(order);
		 * transaction.setTimestamp(LocalDateTime.now());
		 * transaction.setPaymentMode("Wallet");
		 * 
		 * transactionRepository.save(transaction); employeeRepository.save(employee);
		 * System.out.println(transaction); System.out.println(employee); return
		 * orderAmount;
		 */

	}

	@Override
	public Transaction addTransaction(Transaction transaction) 
	{
		if(transaction == null)
		{
			throw new TransactionNotFoundException("Transaction not found");
		}
		
		transaction.setPaymentMode("Wallet");
		transaction.setTimestamp(LocalDateTime.now());
		//transaction.setOrder(order);
		return transactionRepository.save(transaction);
	}

	@Override
	public Order getTransactionById(int orderId) 
	{
		//Transaction transaction=null;// =  transactionRepository.getByEmpId(empId);
		Order orders = orderRepository.findById(orderId).get();
		
		if(orders == null)
		{
			throw new TransactionNotFoundException("Transaction not found with Employee Id: "+orderId);
		}
		
		return orders;
	}

	@Override
	public List<Transaction> getAllTransaction() 
	{
		List<Transaction> allTransaction = transactionRepository.findAll();
		System.out.println("add");
		if(allTransaction.isEmpty())
		{
			throw new TransactionNotFoundException("No transaction found");
		}
		
		return allTransaction;
	}
	
}
