package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

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
	
	public static Connection getConnection_props() throws SQLException, IOException {
		// scan and read data from our properties file:
		FileInputStream fis = new FileInputStream("src/main/resources/db-props.properties");
		
		// Properties is a representation of our Properties file as a Java Object
		Properties props = new Properties();
		props.load(fis);
		
		String url = props.getProperty("CONN_URL");
		String username = props.getProperty("CONN_USER");
		String password = props.getProperty("CONN_PASS");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getConnection_env() throws SQLException {
		String url = System.getenv("ENV_URL");
		String username = System.getenv("ENV_USER");
		String password = System.getenv("ENV_PASS");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
	// Below we are just doing a sanity check to make sure our connection is working.
	// if we get an error, this may mean that we need to update the user permissions in our DB
	public static void main(String[] args) {
		try {
			getConnection_env();
			System.out.println("Connection was successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection was NOT successful");
		}
	}
}
