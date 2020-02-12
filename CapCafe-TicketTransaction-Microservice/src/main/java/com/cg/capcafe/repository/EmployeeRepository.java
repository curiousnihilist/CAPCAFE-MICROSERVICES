package com.cg.capcafe.repository;


/**
 *  @author Sameer Mandavia
 *  Interface Name:- EmployeeRepository 
 *  Description :- EmployeeRepository implements JpaRepository.
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Ticket;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{

	@Modifying()
	@Query("UPDATE Employee employee SET employee.wallet =?1 WHERE employee.empId =?2")
	double updateWallet(double wallet,int empId);
	
	
	
}
