package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Order;
import com.revature.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) throws Exception {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new Exception("Order not found"));
    }
    
    public List<Order> getOrdersByCustomer(Long customer_id) {
    	return orderRepository.findAllByCustomerId(customer_id);
    }
    
    public Order insertOrder(Order order) {
    	return orderRepository.save(order);
    }
    
    public Integer updateOrderTotal(Long order_id, Double order_total) throws Exception {
        int updatedRows = orderRepository.updateOrderTotal(order_total, order_id);
        if (updatedRows == 0) {
            throw new Exception("Order not found with id " + order_id);
        }
        
        return updatedRows;
    }
    
    public Integer deleteOrder(Long order_id) throws Exception {
    	Order order = orderRepository.findById(order_id)
    			.orElseThrow( () -> new Exception("No order found with id: " + order_id));
    	
    	orderRepository.delete(order);
    	
    	return 1;
    }
}
