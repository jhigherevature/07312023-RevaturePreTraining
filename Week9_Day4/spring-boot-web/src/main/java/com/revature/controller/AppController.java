package com.revature.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.apiexceptions.BadRequestException;
import com.revature.model.Product;
import com.revature.service.ProductService;

@RestController
public class AppController {
	
	private final ProductService productService;
	
	@Autowired
	public AppController(ProductService productService) {
		this.productService = productService;
	}
	
	/*
	 * @RequestParam will also parse data in the URL of the HTTP Request.
	 * However the data should be in the form of an HTML Form Parameter
	 */
	@GetMapping("/greet")
	public String sayHello (@RequestParam String name){
		return "Hello " + name;		
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	
	
	
	
	
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable Long id) {
		// Because productService is returning an Optional<Product> I can use 'orElseThrow'
		return productService.getProductById(id).orElseThrow(NoSuchElementException::new);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		try {
			Product addedProduct = productService.addProduct(product);
			// Everything went ok!
			return new ResponseEntity<Product> (addedProduct, HttpStatus.OK);
		} catch (Exception e) {
			// When adding a product, the only issue we can run into is a "bad request" see service for more details
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PatchMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		try {
			Product updatedProduct = productService.updateProduct(product, id);
			return new ResponseEntity<Product> (updatedProduct, HttpStatus.OK);
		} catch (BadRequestException e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		return productService.deleteProductById(id).orElseThrow(NoSuchElementException::new);
	}
	

}
