package dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import models.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl_pgsql implements EmployeeDAO {

	@Override
	public Employee selectEmployeeById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		// '?' are parameters (placeholders) for data we will insert into our prepared statements later...
		String query = "SELECT * FROM training731.employees WHERE emp_id=?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(query);
			
			/* setter methods for our prepared statement allow us to populate parameters in the 
			 * PreparedStatement query String
			 * 
			 * the parameters that we supply start indexing at 1
			 * 
			 *  preparedStatement.set<Datatype>( param_index, param_value );
			 */
			ps.setInt(1, id);
			
			/*
			 * PreparedStatements have 3 methods we can call to execute queries.
			 * executeQuery - used with 'SELECT' operations when we want to get a resultset from our database
			 * executeUpdate - used with 'INSERT', 'UPDATE', 'DELETE' operations. returns # of rows changed
			 * execute - used with all statement types. Will return a boolean whether successful or not
			 */
			rs = ps.executeQuery();
			
			while (rs.next()) {
				/*
				 * ResultSet has 'getter' methods that can take either the column index (starting at 1) OR 
				 * the column name to specify which value we want to get from our DB.
				 */
				emp = new Employee (
						rs.getInt("emp_id"),
						rs.getString("emp_name"),
						rs.getString("emp_title"),
						rs.getDouble("emp_salary")
				);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return emp;
	}
	
//	public Employee selectEmployeeByString(String name) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Employee emp = null;
//		/*
//		 * "SELECT * FROM employees WHERE salary > 100000"
//		 */
//		String query = "SELECT * FROM training731.employees WHERE emp_name="+name;
//		
//		return emp;
//	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
		String query = "INSERT INTO training731.employees VALUES(DEFAULT,?,?,?)";
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());

			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean updateEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
