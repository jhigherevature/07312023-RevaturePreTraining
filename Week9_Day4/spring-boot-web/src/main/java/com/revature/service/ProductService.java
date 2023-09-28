package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.apiexceptions.BadRequestException;
import com.revature.model.Product;
import com.revature.repository.ProductRepository;


@Service
public class ProductService {
	
	private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
    	this.productRepository = productRepository;
    }
    
    public List<Product> getProducts() {
    	return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
    	// Perhaps some business logic here could be to check if the id is null...
    	
    	return productRepository.findById(id);
    }
    
    public Product addProduct(Product product) throws Exception {
    	if (product.getItemPrice() < 0)
    		throw new BadRequestException("Price Cannot be less than 0");
    	
    	if (product.getName().length() < 3)
    		throw new BadRequestException("Product Name must be at least 3 characters long");
    	
    	// We have .get() here because our Repo is returning an Optional value 
    	return productRepository.save(product).get();
    }
    
    public Product updateProduct(Product product, Long product_id) throws BadRequestException {
    	if ( productRepository.findById(product_id).isEmpty() )
    		throw new BadRequestException("Product ID not found");
    	
    	if (product.getItemPrice() < 0)
    		throw new BadRequestException("Price Cannot be less than 0");
    	
    	if (product.getName().length() < 3)
    		throw new BadRequestException("Product Name must be at least 3 characters long");
    	
    	
    	product.setId(product_id);
    	return productRepository.update(product).get();
    }
    
    public Optional<Product> deleteProductById(Long id) {
    	Optional<Product> product = productRepository.findById(id);
    	// Here we could check if the product is an empty optional and perform some logic... 
    	
    	productRepository.deleteById(id);
    	return product;
    }
}