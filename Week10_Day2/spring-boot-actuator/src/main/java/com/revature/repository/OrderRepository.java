package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

	/*
	 * When using the indexing strategy with the @Query annotation, the index
	 * for parameters in the query should match the order of arguments for the
	 * method annotated.
	 */
	@Query(value="SELECT * FROM orders WHERE customer_id= ?1", nativeQuery=true)
	List<Order> findAllByCustomerId(Long customer_id);
	
    @Modifying
    @Transactional
    @Query(value="UPDATE Order SET order_total = ?1 WHERE order_id = ?2", nativeQuery=true)
    int updateOrderTotal(Double orderTotal, Long id);

}
