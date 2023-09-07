package com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.util.ConnectionUtil;

public class EmployeeRepository {

	public Employee selectEmployeeById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		String query = "SELECT * FROM training731.employees WHERE emp_id=?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp = new Employee (
						rs.getInt("emp_id"),
						rs.getString("emp_name"),
						rs.getString("emp_title"),
						rs.getDouble("emp_salary")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	public List<Employee> selectAllEmployees() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Employee> eList = new ArrayList<Employee> ();
		String query = "SELECT * FROM training731.employees";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				eList.add(new Employee (
						rs.getInt("emp_id"),
						rs.getString("emp_name"),
						rs.getString("emp_title"),
						rs.getDouble("emp_salary")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eList;
	}

	public Employee insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
		String query = "INSERT INTO training731.employees VALUES(DEFAULT,?,?,?)";
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				emp.setEmp_id( rs.getInt(1) );
			else
				return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return emp;
	}
	
	public Integer updateEmployee(Employee emp) {
		PreparedStatement ps = null;
		String query = "UPDATE training731.employees SET emp_name=?, emp_title=?, emp_salary=? WHERE emp_id=?";
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query);
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setInt(4, emp.getEmp_id());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public Integer deleteEmployee(Integer id) {
		PreparedStatement ps = null;
		String query = "DELETE FROM training731.employees WHERE emp_id=?";
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
