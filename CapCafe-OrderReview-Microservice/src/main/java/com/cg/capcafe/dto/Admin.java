package com.cg.capcafe.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int empId;
	
	@Column(name = "capgemini_id", nullable = false, unique = true)
	private int capgeminiId;
	
	@Column
	private String email;
	
	private String password;

	@Column(length = 15)
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
