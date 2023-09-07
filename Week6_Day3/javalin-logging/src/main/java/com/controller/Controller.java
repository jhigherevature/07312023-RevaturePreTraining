package com.controller;

import com.app.App;

import io.javalin.Javalin;

public class Controller {	
	public void setEndpoints(Javalin app) {
		app.get("/employees", App.geteServ()::getAllEmployees);
		app.get("/employees/{id}", App.geteServ()::getEmployeeById);
		app.post("/employees", App.geteServ()::addEmployee);
		app.patch("/employees/{id}", App.geteServ()::updateEmployeeById);
		app.delete("/employees/{id}", App.geteServ()::deleteEmployeeById);
		
		app.post("login", App.getlServ()::login);
		app.post("create-login", App.getlServ()::addLogin);
		app.patch("login/{emp-id}", App.getlServ()::updateEmployeeLogin);
		app.delete("login/{emp-id}", App.getlServ()::deleteEmployeeLogin);
	}
}
