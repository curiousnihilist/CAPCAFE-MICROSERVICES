package com.cg.capcafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Ticket;
import com.cg.capcafe.dto.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> 
{
	
//	@Query("SELECT t FROM Transaction t JOIN FETCH t.employee e WHERE e.empId=:empId")
//	@Query("SELECT t FROM Transaction t JOIN FETCH t.Order o WHERE o.empId=:empId ")
//	List<Transaction> getByEmpId(int empId);
}
