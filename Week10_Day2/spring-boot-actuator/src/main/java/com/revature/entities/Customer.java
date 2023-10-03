package com.revature.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Data // The @Data annotation provides the @Getter, @Setter, @EqualsAndHashCode and @ToString annotations
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
	
	public Customer(String customer_name) {
		super();
		this.customer_name = customer_name;
	}

	public Customer(Long customer_id, String customer_name) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
	}
}
