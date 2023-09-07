package com.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controller.Controller;
import com.repository.EmployeeRepository;
import com.repository.LoginRepository;
import com.service.EmployeeService;
import com.service.LoginService;

import io.javalin.Javalin;

public class App {
	private static Controller controller = new Controller();
	private static EmployeeService eServ = new EmployeeService();
	private static LoginService lServ = new LoginService();
	private static EmployeeRepository eRepo = new EmployeeRepository(); 
	private static LoginRepository lRepo = new LoginRepository(); 
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		Javalin app = Javalin.create();
		controller.setEndpoints(app);
		app.start(8080);
		logger.info("Application Started");
	}

	public static Controller getController() {
		return controller;
	}

	public static EmployeeService geteServ() {
		return eServ;
	}

	public static LoginService getlServ() {
		return lServ;
	}

	public static EmployeeRepository geteRepo() {
		return eRepo;
	}

	public static LoginRepository getlRepo() {
		return lRepo;
	}
}
