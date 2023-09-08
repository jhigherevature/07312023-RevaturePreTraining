package com.model;

public class EmployeeLogin {
	private Integer login_id;
	private Integer emp_id;
	private String login_name;
	private String login_pass;
	
	public EmployeeLogin() {
		super();
	}
	public EmployeeLogin(Integer login_id, Integer emp_id, String login_name, String login_pass) {
		super();
		this.login_id = login_id;
		this.emp_id = emp_id;
		this.login_name = login_name;
		this.login_pass = login_pass;
	}
	
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
		result = prime * result + ((login_id == null) ? 0 : login_id.hashCode());
		result = prime * result + ((login_name == null) ? 0 : login_name.hashCode());
		result = prime * result + ((login_pass == null) ? 0 : login_pass.hashCode());
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
		EmployeeLogin other = (EmployeeLogin) obj;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		} else if (!emp_id.equals(other.emp_id))
			return false;
		if (login_id == null) {
			if (other.login_id != null)
				return false;
		} else if (!login_id.equals(other.login_id))
			return false;
		if (login_name == null) {
			if (other.login_name != null)
				return false;
		} else if (!login_name.equals(other.login_name))
			return false;
		if (login_pass == null) {
			if (other.login_pass != null)
				return false;
		} else if (!login_pass.equals(other.login_pass))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EmployeeLogin [login_id=" + login_id + ", emp_id=" + emp_id + ", login_name=" + login_name
				+ ", login_pass=" + login_pass + "]";
	}
}
