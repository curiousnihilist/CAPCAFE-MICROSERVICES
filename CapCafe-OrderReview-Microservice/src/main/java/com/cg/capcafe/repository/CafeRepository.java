package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.capcafe.dto.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{
	
	@Modifying
	@Query("UPDATE Cafe c SET c.avgRating=?1 WHERE c.cafeId=?2")
	int updateRating(double avgRating, int cafeId);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Cafe cafe SET cafe.account =?1 WHERE cafe.cafeId =?2")
	int updateCafeAccount(double account,int cafeId);
	

}
