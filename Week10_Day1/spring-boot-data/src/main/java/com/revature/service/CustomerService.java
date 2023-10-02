package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Customer;
import com.revature.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomerById(Long customerId) throws Exception {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new Exception("Customer not found"));
    }
    
    public Customer insertCustomer(Customer customer) {
    	return customerRepository.save(customer);
    }
    
    public Integer updateCustomerName(Long customer_id, String name) throws Exception {
        int updatedRows = customerRepository.updateCustomerName(customer_id, name);
        if (updatedRows == 0) {
            throw new Exception("Customer not found with id " + customer_id);
        }
        
        return updatedRows;
    }
    
    public Integer deleteCustomer(Long customer_id) throws Exception {
    	Customer customer = customerRepository.findById(customer_id)
    			.orElseThrow( () -> new Exception("No customer found with id: " + customer_id));
    	customerRepository.delete(customer);
    	
    	return 1;
    }
}
