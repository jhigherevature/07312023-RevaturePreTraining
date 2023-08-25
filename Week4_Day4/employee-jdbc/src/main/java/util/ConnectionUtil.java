package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
	/*
	 * DriverManager : create and return our Connection Object
	 * Connection : Create Statement objects and allow us to execute queries on our database
	 */
	public static Connection getConnection() throws SQLException {
		// different drivers will have slightly altered syntax for the database url
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "training";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnectionToPostgreDatabase() throws SQLException {
		// different drivers will have slightly altered syntax for the database url
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "training";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnectionToMySQLDatabase() throws SQLException {
		// different drivers will have slightly altered syntax for the database url
		String url = "mySqlDriverString";
		String username = "training";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
	
	// Below we are just doing a sanity check to make sure our connection is working.
	// if we get an error, this may mean that we need to update the user permissions in our DB
	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection was successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection was NOT successful");
		}
	}
}
