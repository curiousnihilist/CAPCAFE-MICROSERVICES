package com.cg.capcafe.service;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.dto.Order;

public interface ITransactionService 
{
	public double payment(Order order,Employee employee);
}
