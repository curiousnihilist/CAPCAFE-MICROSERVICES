package com.cg.capcafe.service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.TicketStatus;
import com.cg.capcafe.exception.EmployeeNotFoundException;
import com.cg.capcafe.exception.TicketNotFoundException;

/**
 * Interface Name:- TicketCrudService
 * Description:- Has Three methods getAllQuery(),getSingleQuery(),sendResponse().
 * */
public interface TicketCrudService
{

	public List<Ticket> getAllQueries()throws TicketNotFoundException;		//Using this we get all the Employees raised Queries.
	
	//public Ticket getSingleQuery(int empId);	//We get Query of a particular Employee.
	
	public Ticket getSingleQuery(int ticketId)throws TicketNotFoundException;
	
	public Ticket sendResponse(Ticket ticket)throws TicketNotFoundException;	//It will send the solution to the employee and change the status.
	
	
	public Ticket getTicket(int ticketId)throws TicketNotFoundException;
	
	public Employee addEmployee(Employee employee)throws EmployeeNotFoundException; // For Dummy data
	
	public Ticket raiseTicket(Ticket ticket)throws TicketNotFoundException;
	
	//public Ticket getSingleTicket_Of_Employee(int empId, int ticketId); 
	
	//public String raised(int empId,String query);
	
	 
	

}

