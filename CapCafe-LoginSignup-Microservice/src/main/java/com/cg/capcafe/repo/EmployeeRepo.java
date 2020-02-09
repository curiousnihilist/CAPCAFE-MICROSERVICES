package com.cg.capcafe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capcafe.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.capgeminiId=:capgeminiId")
	public Employee findEmployeeByCapgId(@Param("capgeminiId") int capgeminiId);
}
