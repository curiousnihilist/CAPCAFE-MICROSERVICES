package com.cg.capcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capcafe.dto.Admin;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Login;
import com.cg.capcafe.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/capcafe")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.signUp(employee);
	}
	
	@GetMapping(value = "/login/{id}/{password}")
	public Employee login(@PathVariable int id, @PathVariable String password) {
		return service.login(id, password);
	}
	@PostMapping(value="/employeeLogin")
	public Employee employeeLogin(@RequestBody Login login) {
		System.out.println(login.getCapgeminiId());
		System.out.println(login.getPassword());
		return service.login(login.getCapgeminiId(), login.getPassword());
	}
	@PostMapping(value="/adminLogin")
	public Admin adminLogin(@RequestBody Login login) {
		System.out.println("jhgjghghg");
		System.out.println(login.getCapgeminiId());
		return service.adminLogin(login.getCapgeminiId(), login.getPassword());
	}
	

	
}
