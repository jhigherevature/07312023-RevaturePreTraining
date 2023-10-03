package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Customer;
import com.revature.entities.Order;
import com.revature.service.CustomerService;
import com.revature.service.OrderService;

@RestController
public class AppController {
	private final CustomerService customerService;
	private final OrderService orderService;
	
	@Autowired
	public AppController(CustomerService customerService, OrderService orderService) {
		super();
		this.customerService = customerService;
		this.orderService = orderService;
	}
	
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customer_id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customer_id) {
        try {
			return new ResponseEntity<Customer> (customerService.getCustomerById(customer_id), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
    @PostMapping("/customers")
    public ResponseEntity<Customer> insertNewCustomer(@RequestBody Customer customer) {
    	return new ResponseEntity<Customer>(customerService.insertCustomer(customer), HttpStatus.OK);
    }
    
    @PatchMapping("/customers/{customer_id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long customer_id, @RequestBody Customer customer) {
    	try {
			return new ResponseEntity<String> ( 
					customerService.updateCustomerName(customer_id, customer.getCustomer_name()).toString(), 
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
		
    }
    
    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customer_id) {
    	try {
			return new ResponseEntity<String> ( 
					customerService.deleteCustomer(customer_id).toString(), 
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
    }
	
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        try {
			return new ResponseEntity<Order> (orderService.getOrderById(orderId), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
    @GetMapping("customers/{customer_id}/orders")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customer_id) {
    	return orderService.getOrdersByCustomer(customer_id);
    }
    
    @PostMapping("/orders")
    public ResponseEntity<Order> insertNewOrder(@RequestBody Order order) {
    	return new ResponseEntity<Order>(orderService.insertOrder(order), HttpStatus.OK);
    }
    
    @PatchMapping("/orders/{order_id}")
    public ResponseEntity<String> updateOrder(@PathVariable Long order_id, @RequestBody Order order) {
    	try {
			return new ResponseEntity<String> ( 
					orderService.updateOrderTotal(order_id, order.getOrder_total()).toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
    }
    
    @DeleteMapping("/orders/{order_id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long order_id) {
    	try {
			return new ResponseEntity<String> ( 
					orderService.deleteOrder(order_id).toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> (HttpStatus.NO_CONTENT);
		}
    }
    
}
