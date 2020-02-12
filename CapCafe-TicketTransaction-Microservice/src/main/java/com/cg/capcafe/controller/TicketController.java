package com.cg.capcafe.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.TicketStatus;
import com.cg.capcafe.dto.Transaction;
import com.cg.capcafe.exception.EmployeeNotFoundException;
import com.cg.capcafe.exception.TicketNotFoundException;
import com.cg.capcafe.exception.TransactionNotFoundException;
import com.cg.capcafe.service.TicketCrudServiceImpl;
import com.cg.capcafe.service.TransactionServiceImpl;

/**
 * @author Sameer Mandavia
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TicketController 
{

	@Autowired
	TicketCrudServiceImpl ticketService;
	
	@Autowired
	TransactionServiceImpl transactionService;
	
	/********************************* Ticket Part *************************************************************/

	
	/**
	 * 
	 * method name = getAllQueires()
	 * Description = Gives all the Queries to Admin. 
	 * 
	 * */
	
	
	@GetMapping(value="/getAllQueries")
	public List<Ticket> getAllQueries()throws TicketNotFoundException
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
	@GetMapping(value="/getSingleQuery/{ticketId}")
	public Ticket getSingleQuery(@PathVariable int ticketId)throws TicketNotFoundException
	{
		
		return ticketService.getSingleQuery(ticketId);
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
	public Ticket sendResponse(@RequestBody Ticket ticket) throws TicketNotFoundException
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
	 */
	@PostMapping(value="/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeNotFoundException
	{
		return ticketService.addEmployee(employee);
	}
	

	
	/********************************* Ticket Raised Part *************************************************************/

	
	/**
	 * method name:-RaiseTicket is a user part .When the user has to raise ticket User will goes to help desk tab and with the help of 
	 * this method the ticket submit and it will solved by Admin.   
	 * 
	 */
	
	@PostMapping(value="/userRaiseTicket")
	public Ticket raiseTicket(@RequestBody Ticket ticket)
	{
		return ticketService.raiseTicket(ticket);
	}
	
	
	/********************************* Ticket raised *************************************************************/

//	@GetMapping(value="getSingleTicketOfEmployee/{empId}/{ticketId}")
//		public Ticket getSingleTicket_Of_Employee(@PathVariable int empId,@PathVariable int ticketId) 
//		{
//			return ticketService.getSingleTicket_Of_Employee(empId, ticketId);
//		} 
	
	
	@GetMapping(value="/getTotalAmount")
	public double  getTotalAmount(@RequestBody Transaction transaction) throws EmployeeNotFoundException
	{
		System.out.println("controller");
		return transactionService.getTotalAmount(transaction);
		
	}
	
	
	
	//localhost:9999/payment
	@PostMapping(value="/addTransaction")
	public Transaction addTransaction(Transaction transaction) throws TransactionNotFoundException
	{
		//System.out.println(transaction.getOrder().getOrderId());
		System.out.println("payment");
		return transactionService.addTransaction(transaction);	
		
	}
	
	//localhost:9999/getTransactionById/{empId}
	@GetMapping(value="/getTransactionById/{orderId}")
	public Order getTransactionById(@PathVariable int orderId) 
	{
		return transactionService.getTransactionById(orderId);
		
	}
	//localhost:9999/getAllTransactions
	@GetMapping(value="/getAllTransactions")
	public List<Transaction> getAllTransaction() 
	{
		return transactionService.getAllTransaction();
		
	}
	
	 

}
