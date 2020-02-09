package com.cg.capcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capcafe.dto.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

}
