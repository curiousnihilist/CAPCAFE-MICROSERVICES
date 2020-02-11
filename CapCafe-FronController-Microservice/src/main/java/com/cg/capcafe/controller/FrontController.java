package com.cg.capcafe.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.capacfe.dto.Admin;
import com.cg.capacfe.dto.Cafe;
import com.cg.capacfe.dto.Employee;
import com.cg.capacfe.dto.FoodItem;
import com.cg.capacfe.dto.Login;

import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.exception.FoodItemNotFoundException;

@RestController
@RequestMapping(value = "/front")
@CrossOrigin
(origins = "http://localhost:4200")
public class FrontController {
	
	final String serverIp="localhost";
	final String loginSignupMicroservice ="http://" + serverIp + ":8881/capcafe";
	final String cafeDetailsMicroservice="http://" + serverIp + ":8880/cafe";
	final String cafeMenuMicroservice="http://" + serverIp + ":8880/menu";
	//final String userMicroserviceUrl="http://" + serverIp + ":8883/users";
	
	@Autowired
	private RestTemplate template;
	
	// Harshita
	@PostMapping(value = "/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return template.postForObject(loginSignupMicroservice+"/add",employee, Employee.class);
	}
	
	@GetMapping(value = "/login/{id}/{password}")
	public Employee login(@PathVariable int id, @PathVariable String password) {
		return template.getForObject(loginSignupMicroservice+"/login/{id}/{password}", Employee.class);
	}
	@PostMapping(value="/employeeLogin")
	public Employee employeeLogin(@RequestBody Login login) {
		return template.postForObject(loginSignupMicroservice+"/employeeLogin", login, Employee.class);
	}
	@PostMapping(value="/adminLogin")
	public Admin adminLogin(@RequestBody Login login) {
		return template.postForObject(loginSignupMicroservice+"/adminLogin", login, Admin.class);
	}
	
	//Akash
	@PostMapping(value = "/add-cafe")
	public Cafe addCafe(@RequestBody Cafe cafe){
		return template.postForObject(cafeDetailsMicroservice+"/add-cafe", cafe, Cafe.class);
	}
	
	@PutMapping(value = "/update-cafe")
	public Cafe updateCafe(@RequestBody Cafe cafe) {
		template.put(cafeDetailsMicroservice+"/update-cafe", cafe);
		return cafe;
	}
	
	@DeleteMapping(value = "/delete-cafe")
	public boolean deleteCafe(@RequestParam int cafeId) throws CafeNotFoundException{
		template.delete(cafeDetailsMicroservice+"?cafeId="+cafeId);
		return true;
	}
	
	
	@GetMapping(value = "/get-all-cafe")
	public List<Cafe> getAllCafe() throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-all-cafe", Cafe[].class));
	}
	
	@GetMapping(value = "/get-by-id")
	public Cafe getCafeById(@RequestParam int cafeId) throws CafeNotFoundException{
		return template.getForObject(cafeDetailsMicroservice+"/get-by-id"+"?cafeId="+cafeId, Cafe.class);
	}
	
	@GetMapping(value = "/get-by-name")
	public List<Cafe> getCafeByName(@RequestParam String name) throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-by-name"+"?name="+name, Cafe[].class));
	}
	
	@GetMapping(value = "/get-by-location")
	public List<Cafe> getCafeByLocation(@RequestParam String location) throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-by-location"+"?location="+location, Cafe[].class));
	}
	
	@GetMapping(value = "/get-by-dish")
	public List<Cafe> getCafeByDish(@RequestParam String dish) throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-by-dish"+"?name="+dish, Cafe[].class));
	}
	
	@GetMapping(value = "/get-by-rating-range")
	public List<Cafe> getCafeByRatingRange(@RequestParam double min, @RequestParam double max) throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-by-rating-range"+"?min="+max+"&max="+max, Cafe[].class));
	}
	
	@GetMapping(value = "/get-by-price-range")
	public List<Cafe> getCafeByPriceRange(@RequestParam int min, @RequestParam int max) throws CafeNotFoundException{
		return Arrays.asList(template.getForObject(cafeDetailsMicroservice+"/get-by-price-range"+"?min="+max+"&max="+max, Cafe[].class));
	}
	
	@PostMapping(value = "/add-item")
	public FoodItem addDish(@RequestBody FoodItem foodItem) {
		return template.postForObject(cafeMenuMicroservice+"/add-item", foodItem, FoodItem.class);
	}
	
	@PutMapping(value = "/update-item")
	public FoodItem updateDish(@RequestBody FoodItem foodItem) {
		template.put(cafeMenuMicroservice+"/update-item", foodItem);
		return foodItem;
	}
	
	@DeleteMapping(value = "/delete-item")
	public int deleteDish(@RequestParam int itemId) throws FoodItemNotFoundException{
		template.delete(cafeMenuMicroservice+"/delete-item"+"?itemId="+itemId);
		return 1;
	}
	
	@GetMapping(value = "/get-dish-by-id")
	public FoodItem getDishById(@RequestParam int itemId) throws FoodItemNotFoundException{
		return template.getForObject(cafeMenuMicroservice+"/get-dish-by-id"+"?itemId="+itemId, FoodItem.class);
	}
	
	@GetMapping(value = "/get-all-dishes")
	public List<FoodItem> getAllDishes() throws FoodItemNotFoundException{
		return Arrays.asList(template.getForObject(cafeMenuMicroservice+"/get-all-dishes", FoodItem[].class));
	}

}
