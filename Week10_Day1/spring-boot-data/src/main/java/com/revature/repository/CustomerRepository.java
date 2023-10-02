package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/*
	 * Instead of using parameter indexing in the query, you can refer to the 
	 * parameter values using the name and the '@Param' annotation
	 */
	@Modifying
    @Transactional
    @Query(value="UPDATE Customer SET customer_name = :name WHERE customer_id = :id")
    int updateCustomerName(@Param("id") Long customerId, @Param("name") String customerName);
}
