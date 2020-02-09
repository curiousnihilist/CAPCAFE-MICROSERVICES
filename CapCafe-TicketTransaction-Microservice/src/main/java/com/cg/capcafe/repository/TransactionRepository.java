package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capcafe.dto.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> 
{

}
