package com.cg.capacfe.dto;

import java.time.LocalDate;
import java.util.List;


public class Admin {
	private int empId;
	
	private int capgeminiId;
	
	private String email;
	
	private String password;

	private String name;
	
	public Admin() {
		
	}

	public Admin(int empId, int capgeminiId, String email, String password, String name) {
		super();
		this.empId = empId;
		this.capgeminiId = capgeminiId;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Admin(int capgeminiId, String email, String password, String name) {
		super();
		this.capgeminiId = capgeminiId;
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public int getCapgeminiId() {
		return capgeminiId;
	}

	public void setCapgeminiId(int capgeminiId) {
		this.capgeminiId = capgeminiId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	
	
	
	
	

}
