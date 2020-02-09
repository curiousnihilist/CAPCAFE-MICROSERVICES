package com.cg.capcafe.service;

import java.util.List;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.TicketStatus;

/**
 * Interface Name:- TicketCrudService
 * Description:- Has Three methods getAllQuery(),getSingleQuery(),sendResponse().
 * */
public interface TicketCrudService
{

	public List<Ticket> getAllQueries();		//Using this we get all the Employees raised Queries.
		
	public List<Ticket> getSingleQuery(int empId);//We get Query of a particular Employee.
	
	public Ticket sendResponse(Ticket ticket);	//It will send the solution to the employee and change the status.
		
	public Employee addEmployee(Employee employee); // For Dummy data
	
	public Ticket raiseTicket(Ticket ticket);//user can raised the ticket for complaint against order or cafe.

	//public Ticket getSingleTicket_Of_Employee(int empId,int ticketId);
}

