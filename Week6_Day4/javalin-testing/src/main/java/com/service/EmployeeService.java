package com.service;

import java.util.List;

import com.model.Employee;
import com.repository.EmployeeRepository;

import io.javalin.http.Context;

public class EmployeeService {
	EmployeeRepository eRepo;
	
	public EmployeeService() {}
	
	public EmployeeService(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}

	public void getEmployeeById(Context ctx) {
		Integer id = Integer.valueOf( ctx.pathParam("id") );
		Employee e = eRepo.selectEmployeeById( id );
		
		if (e != null) ctx.json(e);
		else ctx.status(400).result("Employee Not Found");
	}
	
	public void getAllEmployees(Context ctx) {
		List<Employee> employees = eRepo.selectAllEmployees();
		ctx.json(employees);
		ctx.status(200);
	}
	
	public void addEmployee(Context ctx) {
		Employee body = ctx.bodyAsClass(Employee.class);
		Employee returned = eRepo.insertIntoEmployees(body);
		if (returned != null) ctx.json( returned );
		else ctx.status(400).result("Employee could not be added");
	}
	
	public void updateEmployeeById(Context ctx) {
		Employee e = ctx.bodyAsClass(Employee.class);
		e.setEmp_id( Integer.valueOf(ctx.pathParam("id")));
		int rowsUpdated = eRepo.updateEmployee(e);
		if (rowsUpdated > 0) ctx.json(e);
		else ctx.status(400).result("Employee could not be updated");
	}
	
	public void deleteEmployeeById(Context ctx) {
		int id = Integer.valueOf( ctx.pathParam("id") );
		int rowsUpdated = eRepo.deleteEmployee(id);
		if (rowsUpdated > 0) ctx.result("Employee successfully deleted");
		else ctx.status(400).result("Employee could not be deleted");		
	}
}
