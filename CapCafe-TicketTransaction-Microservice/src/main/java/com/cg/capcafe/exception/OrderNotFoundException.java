package com.cg.capcafe.exception;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() 
	{
		super();
	
	}

	public OrderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public OrderNotFoundException(String message, Throwable cause) 
	{
		super(message, cause);
		
	}

	public OrderNotFoundException(String message) 
	{
		super(message);
	
	}

	public OrderNotFoundException(Throwable cause) 
	{
		super(cause);
		
	}

		
	
}
