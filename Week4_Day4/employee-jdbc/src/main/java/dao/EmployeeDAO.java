package dao;

import java.util.List;

import models.Employee;

public interface EmployeeDAO {
	public Employee selectEmployeeById(Integer id);
	public List<Employee> selectAllEmployees();
	
	public Boolean insertIntoEmployees(Employee emp);
	public Boolean updateEmployeeById(Integer id);
	public Boolean deleteEmployeeById(Integer id);
}
