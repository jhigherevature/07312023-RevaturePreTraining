package com.model;

public class Employee {
	private Integer emp_id;
	private String emp_name;
	private String emp_title;
	private Double emp_salary;
	
	public Employee() {
		super();
	}

	public Employee(Integer emp_id, String emp_name, String emp_title, Double emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_title = emp_title;
		this.emp_salary = emp_salary;
	}
	
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_title() {
		return emp_title;
	}
	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}
	public Double getEmp_salary() {
		return emp_salary;
	}
	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
		result = prime * result + ((emp_name == null) ? 0 : emp_name.hashCode());
		result = prime * result + ((emp_salary == null) ? 0 : emp_salary.hashCode());
		result = prime * result + ((emp_title == null) ? 0 : emp_title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		} else if (!emp_id.equals(other.emp_id))
			return false;
		if (emp_name == null) {
			if (other.emp_name != null)
				return false;
		} else if (!emp_name.equals(other.emp_name))
			return false;
		if (emp_salary == null) {
			if (other.emp_salary != null)
				return false;
		} else if (!emp_salary.equals(other.emp_salary))
			return false;
		if (emp_title == null) {
			if (other.emp_title != null)
				return false;
		} else if (!emp_title.equals(other.emp_title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + 
				", emp_name=" + emp_name + 
				", emp_title=" + emp_title + 
				", emp_salary="+ emp_salary + "]";
	}
}
