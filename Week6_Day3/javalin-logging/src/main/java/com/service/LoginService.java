package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.App;
import com.model.EmployeeLogin;

import io.javalin.http.Context;

public class LoginService {
	
	private final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	public void login(Context ctx) {
		logger.trace("Attempting Login");
		EmployeeLogin body = ctx.bodyAsClass(EmployeeLogin.class);
		EmployeeLogin returned = App.getlRepo().selectLoginByCredentials(body.getLogin_name(), body.getLogin_pass());
		
		if (returned != null) {
			ctx.status(200).result("Login Successful");
			logger.info("Login Successful");
		}
		else {
			ctx.status(400).result("Login Unsuccessful");
			logger.info("Login Unsuccessful");
		}
	}

	public void addLogin(Context ctx) {
		EmployeeLogin body = ctx.bodyAsClass(EmployeeLogin.class);
		if (body.getLogin_name() == null || body.getLogin_name().length() < 4) {
			ctx.status(400).result("Username Violation");
			return;
		}

		if (body.getLogin_pass() == null || body.getLogin_pass().length() < 4) {
			ctx.status(400).result("Password Violation");
			return;
		}

		if (App.getlRepo().insertIntoEmployeeLogin(body))
			ctx.status(200).result("New Login Credential Created Successfully");
		else
			ctx.status(400).result("Login Credentials were not accepted");
	}

	public void updateEmployeeLogin(Context ctx) {
		EmployeeLogin elogin = ctx.bodyAsClass(EmployeeLogin.class);
		int id = Integer.valueOf(ctx.pathParam("emp-id"));
		elogin.setEmp_id(id);
		int rowsUpdated = App.getlRepo().updateEmployeeLogin(elogin);
		if (rowsUpdated > 0)
			ctx.result("Login Details Updated");
		else
			ctx.status(400).result("Login Details were not updated");
	}

	public void deleteEmployeeLogin(Context ctx) {
		int id = Integer.valueOf(ctx.pathParam("emp-id"));
		int rowsUpdated = App.getlRepo().deleteEmployeeLogin(id);
		if (rowsUpdated > 0)
			ctx.result("Login Details Successfully deleted");
		else
			ctx.status(400).result("Login Details were not deleted");
	}
}
