package com.cg.capcafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * Interface Name:- TicketCrudRepository
 * 
 * */


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Ticket;
/**
 *  @author Sameer Mandavia
 *  Interface Name:- TicketCrudRepository 
 *  Description :- TicketCrudRepository implements JpaRepository.
 */

@Repository
public interface TicketCrudRepository extends JpaRepository<Ticket, Integer> 
{
	//To fetch the tickets of particular Employee 
	@Query("SELECT t FROM Ticket t JOIN FETCH t.employee e WHERE e.empId=:empId")
	List<Ticket> getByEmpId(int empId);
	
	//To fetch single ticket of a particular Employee 
//	@Query("SELECT t FROM Ticket t JOIN FETCH t.employee e WHERE t.ticketId=:ticketId AND e.empId=:empId")
//	Ticket getSingleTicketOfEmployee(int empId,int ticketId);
	
}
