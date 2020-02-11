package com.cg.capcafe.service;

import java.util.List;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Transaction;
import com.cg.capcafe.exception.EmployeeNotFoundException;
import com.cg.capcafe.exception.TransactionNotFoundException;

public interface ITransactionService 
{
	public double getTotalAmount(Transaction transaction)throws TransactionNotFoundException;
	
	public Transaction addTransaction(Transaction transaction)throws TransactionNotFoundException;
	
	public Order getTransactionById(int orderId)throws TransactionNotFoundException;
	
	public List<Transaction> getAllTransaction()throws TransactionNotFoundException; 
}
