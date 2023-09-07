package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.EmployeeLogin;
import com.util.ConnectionUtil;

public class LoginRepository {
	
	public EmployeeLogin selectLoginByCredentials(String username, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeLogin login = null;
		String query = "SELECT * FROM training731.employeelogin WHERE login_name=? AND login_pass=?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				login = new EmployeeLogin (
						rs.getInt("login_id"),
						rs.getInt("emp_id"),
						rs.getString("login_name"),
						rs.getString("login_pass")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return login;
	}
	
	public Boolean insertIntoEmployeeLogin(EmployeeLogin login) {
		PreparedStatement ps = null;
		String query = "INSERT INTO training731.employeelogin VALUES(DEFAULT,?,?,?)";
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query);
			ps.setInt(1, login.getEmp_id());
			ps.setString(2, login.getLogin_name());
			ps.setString(3, login.getLogin_pass());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Integer updateEmployeeLogin(EmployeeLogin login) {
		PreparedStatement ps = null;
		String query = "UPDATE training731.employeelogin SET login_name=?, login_pass=? WHERE emp_id=?";
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query);
			ps.setString(1, login.getLogin_name());
			ps.setString(2, login.getLogin_pass());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Integer deleteEmployeeLogin(Integer id) {
		PreparedStatement ps = null;
		String query = "DELETE FROM training731.employeelogin WHERE emp_id=?";
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
