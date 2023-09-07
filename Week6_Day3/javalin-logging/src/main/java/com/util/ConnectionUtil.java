package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		// different drivers will have slightly altered syntax for the database url
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "training";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);
	}
}
