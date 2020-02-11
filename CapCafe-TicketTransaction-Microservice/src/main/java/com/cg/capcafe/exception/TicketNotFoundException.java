package com.cg.capcafe.exception;


/**
 * @author Sameer Mandavia
 * Class name:- TicketNotFoundException
 * 
 * 
 * */


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)

public class TicketNotFoundException extends RuntimeException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TicketNotFoundException() 
	{
		super();
		
	}

	public TicketNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public TicketNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
		
	}

	public TicketNotFoundException(String message) 
	{
		super(message);
		
	}

	public TicketNotFoundException(Throwable cause) 
	{
		super(cause);
		
	}
	
	
}
