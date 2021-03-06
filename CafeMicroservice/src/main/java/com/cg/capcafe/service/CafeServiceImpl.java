package com.cg.capcafe.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.dto.FoodItem;
import com.cg.capcafe.dto.Order;
import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.exception.FoodItemNotFoundException;
import com.cg.capcafe.repo.CafeRepository;
import com.cg.capcafe.repo.OrderRepository;

/**
 * Implememtation for CafeService interface. It contains business logics for Cafe service.
 * @author Akash Verma
 *
 */
@Service
@Transactional
public class CafeServiceImpl implements CafeService{

	private CafeRepository cafeRepo;
	private OrderRepository orderRepo;
	
	@Autowired
	public CafeServiceImpl(CafeRepository cafeRepo,OrderRepository orderRepo) {
		this.cafeRepo = cafeRepo;
		this.orderRepo = orderRepo;
		
	}
	
	@Override
	public Cafe searchById(int cafeId) throws CafeNotFoundException {
		Optional<Cafe> cafe = cafeRepo.findById(cafeId);
		if(!cafe.isPresent())
			throw new CafeNotFoundException("No Cafe Found with ID : "+cafeId);
		return cafe.get();
	}

	@Override
	public Cafe addCafe(Cafe cafe) {
		List<FoodItem> menu = cafe.getMenu();
		Iterator<FoodItem> menuItr = menu.iterator();
		int sum = 0;
		while(menuItr.hasNext()) {
			sum = (int) (sum + menuItr.next().getPrice());
		}
		sum = (int) sum/menu.size();
		cafe.setAvgPrice(sum);
		return cafeRepo.saveAndFlush(cafe);
	}

	@Override
	public Cafe updateCafe(Cafe cafe) {
		
		//cafeRepo.deleteById(cafe.getCafeId());
		
		System.out.println(cafeRepo.existsById(cafe.getCafeId()));
		return cafeRepo.save(cafe);
	}

	@Override
	public boolean deleteCafe(int cafeId) throws CafeNotFoundException{
		try {
			cafeRepo.deleteById(cafeId);
			return true;
		} catch (Exception e) {
			throw new CafeNotFoundException("No Cafe exist with Id: "+cafeId);
		}
	}

	@Override
	public List<Cafe> searchByPricing(int min, int max) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByPriceRange(min, max);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found with specified price range : "+min+"-"+max);
		return cafes;
	}

	@Override
	public List<Cafe> searchByRatings(double min, double max) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByRatingRange(min, max);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found with specified rating range : "+min+"-"+max);
		return cafes;
	}

	@Override
	public List<Cafe> getAllCafe() throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findAll();
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No Cafe Found!");
		return cafes;
	}

	@Override
	public List<Cafe> searchByName(String name) throws CafeNotFoundException {
		name = "%"+name+"%";
		List<Cafe> cafes = cafeRepo.findByNameContainigIgnoreCase(name);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found by the name : "+name);
		return cafes;
	}

	@Override
	public List<Cafe> searchByLocation(String location) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByLocation(location);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe found in location : "+location);
		return cafes;
	}

	@Override
	public List<Cafe> searchByMenu(String foodItem) throws CafeNotFoundException {
		List<Cafe> cafes = cafeRepo.findByMenu(foodItem);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe available!");
		return cafes;
	}

	@Override
	public List<Cafe> searchFood(String name, String location) throws CafeNotFoundException {
		name = "%"+name+"%";
		List<Cafe> cafes = cafeRepo.getFood(name, location);
		if(cafes.isEmpty())
			throw new CafeNotFoundException("No cafe available!");
		return cafes;
	}

	@Override
	public List<FoodItem> searchDish(int cafeId, String dish) throws FoodItemNotFoundException {
		CharSequence seq = dish;
		Cafe cafe = cafeRepo.findById(cafeId).get();
		List<FoodItem> searchResult = new ArrayList<>();
		
		for(FoodItem item:cafe.getMenu()) {
			if(item.getName().contains(seq))
				searchResult.add(item);
		}
		
		if(searchResult.isEmpty())
			throw new FoodItemNotFoundException("No "+dish +" available in the cafe!");
		return searchResult;
	}
	
	@Override
	public List<Order> fetchOrderByEmployeeId(int empId) {
		List<Order> orders=orderRepo.getByEmpId(empId);
		return orders;
		
	}

}
