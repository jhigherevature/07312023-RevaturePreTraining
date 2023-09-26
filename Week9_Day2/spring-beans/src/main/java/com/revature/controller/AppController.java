package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Product;
import com.revature.service.ProductService;

@RestController
public class AppController {
	
	private final ProductService productService;
	
	@Autowired
	public AppController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String hello() {
		return "Hello from our AppController";
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id).orElse(null);
	}
	
	/*
	 * Spring Web provides us with HTTP Mapping annotations for different HTTP Requests:
	 * @PostMapping
	 * @PatchMapping
	 * @DeleteMapping
	 * @PutMapping
	 */
}
