package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capcafe.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
