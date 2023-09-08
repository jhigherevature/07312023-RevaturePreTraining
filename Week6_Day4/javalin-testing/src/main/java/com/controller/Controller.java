package com.controller;

import com.service.EmployeeService;
import com.service.LoginService;

import io.javalin.Javalin;

public class Controller {	
	LoginService lServ;
	EmployeeService eServ;
	
	public Controller() {} 
	public Controller(LoginService lServ, EmployeeService eServ) {
		this.lServ = lServ;
		this.eServ = eServ;
	}
	
	public void setEndpoints(Javalin app) {
		app.get("/employees", eServ::getAllEmployees);
		app.get("/employees/{id}", eServ::getEmployeeById);
		app.post("/employees", eServ::addEmployee);
		app.patch("/employees/{id}", eServ::updateEmployeeById);
		app.delete("/employees/{id}", eServ::deleteEmployeeById);
		
		app.post("login", lServ::login);
		app.post("create-login", lServ::addLogin);
		app.patch("login/{emp-id}", lServ::updateEmployeeLogin);
		app.delete("login/{emp-id}", lServ::deleteEmployeeLogin);
	}
}
