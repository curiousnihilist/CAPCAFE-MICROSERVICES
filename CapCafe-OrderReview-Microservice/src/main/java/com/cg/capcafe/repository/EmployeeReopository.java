package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Employee;

@Repository
public interface EmployeeReopository extends JpaRepository<Employee,Integer> 
{

}  


