package com.cg.capcafe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.cg.capcafe.exception.EmployeeNotFoundException;
//import com.cg.capcafe.exception.ErrorResponse;
//import com.cg.capcafe.exception.OrderNotFoundException;
import com.cg.capcafe.exception.TicketNotFoundException;
import com.cg.capcafe.exception.TransactionNotFoundException;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice 
@RestController
public class TicketExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) 
	{
		 List<String> details = new ArrayList<>();
	     details.add(ex.getLocalizedMessage());
	     //ErrorResponse error = new ErrorResponse("Server Error",details);
	     return new ResponseEntity<>(
        		ex, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<Object> HandleTicketNotFound(TicketNotFoundException ex)
	{
		 List<String> details = new ArrayList<>();
	     details.add(ex.getLocalizedMessage());
		 //ErrorResponse error = new ErrorResponse("Ticket Not Found",details);
		 return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.NOT_FOUND); 
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> HandleEmployeeNotFound(EmployeeNotFoundException ex)
	{
		 List<String> details = new ArrayList<>();
	     details.add(ex.getLocalizedMessage());
		 //ErrorResponse error = new ErrorResponse("Employee Not Found",details);
		 return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> HandleTransactionNotFound(TransactionNotFoundException ex)
	{
		 List<String> details = new ArrayList<>();
	     details.add(ex.getLocalizedMessage());
		 //ErrorResponse error = new ErrorResponse("Transaction Not Found",details);
		 return new ResponseEntity<Object>(ex,new HttpHeaders(),HttpStatus.NOT_FOUND); 
	}
	
	
//	@ExceptionHandler(OrderNotFoundException.class)
//	public ResponseEntity<Object> HandleOrderNotFound(OrderNotFoundException ex)
//	{
//		 List<String> details = new ArrayList<>();
//	     details.add(ex.getLocalizedMessage());
//		 //ErrorResponse error = new ErrorResponse("Order Not Found",details);
//		 return new ResponseEntity<Object>(ex,new HttpHeaders() ,HttpStatus.NOT_FOUND); 
//	}
	
}
