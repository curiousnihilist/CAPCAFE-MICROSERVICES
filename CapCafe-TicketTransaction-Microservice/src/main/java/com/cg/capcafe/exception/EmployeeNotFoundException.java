package com.cg.capcafe.exception;



import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() 
	{
		super();
	
	}

	public EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) 
	{
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public EmployeeNotFoundException(String message, Throwable cause) 
	{
		super(message, cause);
	
	}

	public EmployeeNotFoundException(String message) 
	{
		super(message);
		
	}

	public EmployeeNotFoundException(Throwable cause) 
	{
		super(cause);
		
	}


}
