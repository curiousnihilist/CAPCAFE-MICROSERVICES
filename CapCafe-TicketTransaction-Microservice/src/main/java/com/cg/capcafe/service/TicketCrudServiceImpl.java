package com.cg.capcafe.service;

import java.util.InputMismatchException;

/**
 * Class Name:- TicketCrudServiceImpl.java
 * Description:- Has Three implemented methods getAllQuery(),getSingleQuery(),sendResponse().
 * */

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.TicketStatus;
import com.cg.capcafe.exception.TicketNotFoundException;
import com.cg.capcafe.repository.EmployeeRepository;
import com.cg.capcafe.repository.OrderRepository;
import com.cg.capcafe.repository.TicketCrudRepository;

@Service
@Transactional
public class TicketCrudServiceImpl implements TicketCrudService
{

	@Autowired
	TicketCrudRepository ticketRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@PersistenceContext
	EntityManager manager;
	
	
	/**
	 * 
	 * 	method name:- getAllQueries
	 * 	Description:- It will gives all the queries to the Admin.
	 * 
	 * */
	@Override
	public List<Ticket> getAllQueries() 
	{
		return ticketRepository.findAll();
	}
	
	
	
	
	
	/**
	 * 
	 * 	method name:- getSingleQuery
	 * 	Description:- It will gives a particular Employee query to the Admin.
	 * 
	 * */
	//Working
	@Override
	public List<Ticket> getSingleQuery(int empId) 
	{
		List<Ticket> tickets =  ticketRepository.getByEmpId(empId);
		if(tickets.isEmpty())
			throw new TicketNotFoundException("Ticket with Id: "+empId+" not found.");
		return tickets;
			
	} 

	
		
	/**
	 * 
	 * 	method name:- sendResponse
	 * 	Description:- It will send the response(Solution) to the Employee.
	 * 
	 * */
		//Working
	@Override
	public Ticket sendResponse(Ticket ticket) 
	{
		ticket.setStatus(TicketStatus.RESOLVED);
		System.out.println(ticket);
			
		return ticketRepository.save(ticket);

	}


		
		
	

	
	/**
	 * 
	 * 	method name:- addEmployee
	 * 	Description:- It will add the Employee.
	 * 
	 * */
	//Working
	@Override
	public Employee addEmployee(Employee employee) 
	{
		if(employee != null)
		{
			return employeeRepository.save(employee);
		}
		else
		{
			throw new TicketNotFoundException("Invalid Details");
		}
		
	}

	
	
	/**
	 * 
	 * 	method name:- raiseTicket
	 * 	Description:- Employee can raised the Ticket. 
	 * 
	 * */
	//Working
	@Override
	public Ticket raiseTicket(Ticket ticket) //Ticket ticket 
	{
		ticket.setQuery(ticket.getQuery());
		ticket.setStatus(TicketStatus.UNRESOLVED);
		return ticketRepository.save(ticket);//ticket
	}





//	@Override
//	public Ticket getSingleTicket_Of_Employee(int empId, int ticketId) 
//	{
//		Ticket singleTicket =  ticketRepository.getSingleTicketOfEmployee(empId, ticketId);
//		if(singleTicket == null)
//		{
//			throw new TicketNotFoundException(ticketId+" Ticket Id not found with Employee Id: "+empId);
//		}
//		
//		return singleTicket;
//	}

		
	
	}
