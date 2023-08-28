package main;

import dao.EmployeeDAOImpl_pgsql;
import models.Employee;

public class Main {

	public static void main(String[] args) {
		EmployeeDAOImpl_pgsql eDao = new EmployeeDAOImpl_pgsql ();
		System.out.println("SELECT BY ID 1000");
		System.out.println( eDao.selectEmployeeById(1000) );
		
		System.out.println("INSERTING new Employee to Database:");
		Employee e = new Employee(2000, "From Java App", "Developer", 150000.00);
		eDao.insertIntoEmployees(e);
		
		System.out.println("SELECT NEW ADDED EMPLOYEE:");
		System.out.println( eDao.selectEmployeeById(2000) );
	}

}
