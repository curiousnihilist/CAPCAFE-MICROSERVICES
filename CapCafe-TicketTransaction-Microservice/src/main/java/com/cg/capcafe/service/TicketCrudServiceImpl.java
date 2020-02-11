package com.cg.capcafe.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;

/**
 * Class Name:- TicketCrudServiceImpl.java
 * Description:- Has Three implemented methods getAllQuery(),getSingleQuery(),sendResponse().
 * */

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.capcafe.dto.Employee;
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
	

	
	
	/**
	 * 
	 * 	method name:- getAllQueries
	 * 	Description:- It will gives all the queries to the Admin.
	 * 
	 * */
	@Override
	public List<Ticket> getAllQueries() 
	{
	
		//List<Ticket> listOfTickets = ticketRepository.findAll();
		
//		System.out.println(listOfTickets.get(1).getEmployee());
//		System.out.println(listOfTickets);
//		for (Ticket ticket : listOfTickets) 
//		{
//			System.out.println(ticket.getEmployee());
//		}
		//return listOfTickets;
		System.err.println('k');
		return ticketRepository.findAll().stream().map(ticket-> 
		{
			if(ticket.getEmployee() != null)
			{
				ticket.getEmployee().setTicketsRaised(null);
				return ticket;
			}
			else
			{
				return ticket;
			}
		}).collect(Collectors.toList());

	}
	
	/**
	 * 
	 * 	method name:- getSingleQuery
	 * 	Description:- It will gives a particular Employee query to the Admin.
	 * 
	 * */

	public static <T> List<T> convertSetToList(Set<T> set) 
    { 
       
        List<T> list = new ArrayList<>(); 
        for (T t : set) 
            list.add(t); 
        return list; 
    } 
	
	
		@Override
		//public List<Ticket> getSingleQuery(int empId) 
		public Ticket getSingleQuery(int ticketId)
		{

			//ListTicket> tickets =  ticketRepository.getByEmpId(empId);
			//Employee employee = employeeRepository.findById(empId).get();
			Ticket tickets =  ticketRepository.findById(ticketId).get();
			if(tickets == null)
			{
				throw new TicketNotFoundException("Ticket with Id:"+ticketId+"  not found.");
			}
			
			tickets.getEmployee().setTicketsRaised(null);
//			tickets = tickets.stream().filter(ticket-> ticket.getStatus().equals("UNRESOLVED"));
			
			return tickets;
			
		} 

	/**
	 * 
	 * 	method name:- sendResponse
	 * 	Description:- It will send the response(Solution) to the Employee.
	 * 
	 * */
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
	//working
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

	@Override
	public Ticket raiseTicket(Ticket ticket) //Ticket ticket 
	{

			//ticket.setQuery(ticket.getQuery());
			ticket.setStatus(TicketStatus.UNRESOLVED);
			return ticketRepository.save(ticket);//ticket

	}

	@Override
	public Ticket getTicket(int ticketId) 
	{
		Ticket ticket = ticketRepository.getOne(ticketId);
		return ticket;
	}

//	@Override
//	public String raised(int empId, String query) 
//	{
//		Employee employee = employeeRepository.findById(empId).get();
//		System.out.println(employee);
//		
//		Ticket ticket = new Ticket();
//		
//		ticket.setQuery(query);
//		ticket.setStatus(TicketStatus.UNRESOLVED);
//		ticket.setEmployee(employee);
//		
//		if(ticketRepository.save(ticket)!=null)
//		{
//		return "success";
//		}
//		else {
//			return "fail";
//		}
//	}

	
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
