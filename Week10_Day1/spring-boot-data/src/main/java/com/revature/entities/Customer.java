package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	/*
	 * Please note: the 'GeneratedValue' and 'SequenceGenerator' are used to start
	 * 	the auto-incrementing sequence (as managed by spring) to respect the initial
	 *	test data supplied to this application in the 'data.sql' file.
	 */
	@Column(name="customer_id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
	@SequenceGenerator(name="customer_seq", initialValue=3, allocationSize=1)
	private Long customer_id;
	
	@Column(name="customer_name")
	private String customer_name;

	
	public Customer() {
		super();
	}
	
	public Customer(String customer_name) {
		super();
		this.customer_name = customer_name;
	}

	public Customer(Long customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + "]";
	}
}
