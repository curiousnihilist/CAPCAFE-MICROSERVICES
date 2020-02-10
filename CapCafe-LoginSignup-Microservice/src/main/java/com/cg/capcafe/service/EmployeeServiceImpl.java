package com.cg.capcafe.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Admin;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.repo.AdminRepo;
import com.cg.capcafe.repo.EmployeeRepo;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Autowired
	AdminRepo adminRepo;

	@Override
	public Employee signUp(Employee employee) {
		employee.setSubscriptionDate(LocalDate.now());
		Employee emp = empRepo.save(employee);
		return emp;

	}

	@Override
	public Employee login(int id, String password) {
		Employee employee;
		int capgeminiId=id;
		try {
			employee = empRepo.findEmployeeByCapgId(capgeminiId);
			if(employee.getCapgeminiId()==id && employee.getPassword().equals(password))
			{
				return employee;
			}
			else
			{
				return null;
				
			}
		}
		catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public Admin adminLogin(int id, String password) {
		Admin admin;
		int capgeminiId=id;
		try {
			admin= adminRepo.findEmployeeByCapgId(capgeminiId);
			if(admin.getCapgeminiId()==id && admin.getPassword().equals(password))
			{
				return admin;
			}
			else
			{
				return null;
				
			}
		}
		catch(Exception e) {
			return null;
		}
	}

}
