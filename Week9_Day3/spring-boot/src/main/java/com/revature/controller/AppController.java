package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

@RestController
public class AppController {
	
	private final EmployeeService empService;
	
	@GetMapping
	public String helloWorld() {
		return "Hello from Spring Boot App";
	}
	
	
	@Autowired
	public AppController(EmployeeService empService) {
		this.empService = empService;
	}
	
	// Adding a code comment
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return empService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployees(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}
}
