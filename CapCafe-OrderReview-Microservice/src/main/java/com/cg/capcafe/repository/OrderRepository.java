package com.cg.capcafe.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capcafe.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query("SELECT o FROM Order o JOIN FETCH o.employee e WHERE e.empId=:empId")
	List<Order> getByEmpId(int empId);
	
//	@Query("SELECT o FROM Order o WHERE o.location = :location")
//	List<Order>getByLocation(String location);

}
