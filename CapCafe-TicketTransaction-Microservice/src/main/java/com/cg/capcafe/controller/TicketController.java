package com.cg.capcafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.TicketStatus;
import com.cg.capcafe.service.TicketCrudServiceImpl;

/**
 * @author samemand
 *
 */

@RestController
public class TicketController 
{

	@Autowired
	TicketCrudServiceImpl ticketService;
	
	/********************************* Ticket Part *************************************************************/

	
	/**
	 * 
	 * method name = getAllQueires()
	 * Description = Gives all the Queries to Admin. 
	 * 
	 * */
	
	
	@GetMapping(value="/getAllQueries")
	public List<Ticket> getAllQueries() 
	{
		List<Ticket> allTickets = ticketService.getAllQueries();
		return allTickets;
	}
	
	
	/**
	 * @param empId
	 * 
	 * @return single Query
	 * 
	 * 
	 * */
	@GetMapping(value="/getSingleQuery/{empId}")
	public List<Ticket> getSingleQuery(@PathVariable int empId) 
	{
		
		return ticketService.getSingleQuery(empId);
	}
	
	
	/**
	 * 
	 * @param ticketId
	 * @param message
	 * @return
	 * 
	 * 
	 */
	@PostMapping(value="/sendResponse")
	public Ticket sendResponse(@RequestBody Ticket ticket) 
	{
		return ticketService.sendResponse(ticket);
	}
//	@PostMapping(value="/sendResponse/{ticketId}/{response}")
//	public Ticket sendResponse(@PathVariable int ticketId,@PathVariable String response) 
//	{
//		return ticketService.sendResponse(ticketId, response);
//	}
//	
	
	
	
	/**
	 * method name = addEmployee
	 * Description = Using this the Employee will be added.
	 * */
	/********************************* Ticket   *************************************************************/
	
	
	
	/********************************* Add Employee Part *************************************************************/
	@PostMapping(value="/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) 
	{
		return ticketService.addEmployee(employee);
	}
	
	/********************************* Add Employee  *************************************************************/
	
	
	
	
	/********************************* Ticket Raised Part *************************************************************/

	
	/**
	 * method name:-RaiseTicket is a user part .When the user has to raise ticket User will goes to help desk tab and with the help of 
	 * this method the ticket submit and it will solved by Admin.   
	 * 
	 * */
	@PostMapping(value="/userRaiseTicket")
	public Ticket raiseTicket(@RequestBody Ticket ticket) 
	{
		return ticketService.raiseTicket(ticket);
	}
	
	/********************************* Ticket raised *************************************************************/

	
//	@GetMapping(value="getSingleTicketOfEmployee/{empId}/{ticketId}")
//	public Ticket getSingleTicket_Of_Employee(@PathVariable int empId,@PathVariable int ticketId) 
//	{
//		return ticketService.getSingleTicket_Of_Employee(empId, ticketId);
//	}
	
}
