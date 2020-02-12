package com.cg.capcafe.service;

import com.cg.capcafe.dto.Admin;
import com.cg.capcafe.dto.Employee;

public interface EmployeeService {
	
   public 	Employee signUp(Employee employee);
	
   public 	Employee login(int id, String password);
   
    public Admin adminLogin(int id,String password);
    
    public Employee getEmpById(int empId);

}
