package com.service;

import com.model.EmployeeLogin;
import com.repository.LoginRepository;

import io.javalin.http.Context;

public class LoginService {
	private LoginRepository lRepo;
	
	public LoginService(LoginRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	public LoginService() {}
	
	public void login(Context ctx) {
		EmployeeLogin body = ctx.bodyAsClass(EmployeeLogin.class);
		EmployeeLogin returned = lRepo.selectLoginByCredentials(body.getLogin_name(), body.getLogin_pass());
		
		if (returned != null) {
			ctx.status(200).result("Login Successful");
		}
		else {
			ctx.status(400).result("Login Unsuccessful");
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

		if (lRepo.insertIntoEmployeeLogin(body))
			ctx.status(200).result("New Login Credential Created Successfully");
		else
			ctx.status(400).result("Login Credentials were not accepted");
	}

	public void updateEmployeeLogin(Context ctx) {
		EmployeeLogin elogin = ctx.bodyAsClass(EmployeeLogin.class);
		int id = Integer.valueOf(ctx.pathParam("emp-id"));
		elogin.setEmp_id(id);
		int rowsUpdated = lRepo.updateEmployeeLogin(elogin);
		if (rowsUpdated > 0)
			ctx.result("Login Details Updated");
		else
			ctx.status(400).result("Login Details were not updated");
	}

	public void deleteEmployeeLogin(Context ctx) {
		int id = Integer.valueOf(ctx.pathParam("emp-id"));
		int rowsUpdated = lRepo.deleteEmployeeLogin(id);
		if (rowsUpdated > 0)
			ctx.result("Login Details Successfully deleted");
		else
			ctx.status(400).result("Login Details were not deleted");
	}
}
