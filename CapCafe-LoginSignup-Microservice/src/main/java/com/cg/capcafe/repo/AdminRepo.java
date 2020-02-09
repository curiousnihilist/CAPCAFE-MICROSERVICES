package com.cg.capcafe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capcafe.dto.Admin;
import com.cg.capcafe.dto.Employee;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("select a from Admin a where a.capgeminiId=:capgeminiId")
	public Admin findEmployeeByCapgId(@Param("capgeminiId") int capgeminiId);

}
