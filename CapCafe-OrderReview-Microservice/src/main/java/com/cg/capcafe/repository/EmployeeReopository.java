package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Employee;

@Repository
public interface EmployeeReopository extends JpaRepository<Employee,Integer> 
{
	@Modifying()
	@Query("UPDATE Employee employee SET employee.wallet =employee.wallet + ?1 WHERE employee.empId =?2")
	int updateWallet(double wallet,int empId);
	
	@Modifying()
	@Query("UPDATE Employee employee SET employee.wallet = ?1 WHERE employee.empId =?2")
	int deductWallet(double wallet,int empId);
	
}  


