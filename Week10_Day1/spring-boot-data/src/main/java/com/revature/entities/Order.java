package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	/*
	 * Please note: the 'GeneratedValue' and 'SequenceGenerator' are used to start
	 * 	the auto-incrementing sequence (as managed by spring) to respect the initial
	 *	test data supplied to this application in the 'data.sql' file.
	 */
	@Column(name="order_id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")
	@SequenceGenerator(name="order_seq", initialValue=7, allocationSize=1)
	private Long order_id;
	
	@Column(name="customer_id")
	private Long customer_id;
	
	@Column(name="order_total")
	private Double order_total;
	
	@Column(name="order_date")
	private String order_date;
	
	public Order() {
		super();
	}

	public Order(Long customer_id, Double order_total, String order_date) {
		super();
		this.customer_id = customer_id;
		this.order_total = order_total;
		this.order_date = order_date;
	}

	public Order(Long order_id, Long customer_id, Double order_total, String order_date) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.order_total = order_total;
		this.order_date = order_date;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Double getOrder_total() {
		return order_total;
	}

	public void setOrder_total(Double order_total) {
		this.order_total = order_total;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", order_total=" + order_total
				+ ", order_date=" + order_date + "]";
	}
}
