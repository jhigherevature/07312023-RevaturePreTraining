package models;

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
	public String toString() {
		return "Employee [emp_id=" + emp_id + 
				", emp_name=" + emp_name + 
				", emp_title=" + emp_title + 
				", emp_salary="+ emp_salary + "]";
	}
}
