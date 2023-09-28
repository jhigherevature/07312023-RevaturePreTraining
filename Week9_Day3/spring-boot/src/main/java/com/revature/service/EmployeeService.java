package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	public final EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public List<Employee> getEmployees() {
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(Integer id) {
		return empRepo.findById(id).orElse(null);
	}
}
