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
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		EmployeeRepository eRepo = new EmployeeRepository();
		LoginRepository lRepo = new LoginRepository();
		
		EmployeeService eServ = new EmployeeService(eRepo);
		LoginService lServ = new LoginService(lRepo);
		
		Controller controller = new Controller(lServ,eServ);
		
		Javalin app = Javalin.create();
		controller.setEndpoints(app);
		app.start(8080);
		logger.info("Application Started");
	}
}
