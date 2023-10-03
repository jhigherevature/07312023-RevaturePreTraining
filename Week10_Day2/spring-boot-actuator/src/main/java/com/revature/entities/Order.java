package com.revature.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity
@Table(name="orders")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
}
