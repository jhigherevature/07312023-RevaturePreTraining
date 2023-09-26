package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.model.Product;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Initializing with some data
    	products.add(new Product(1001L, "Sweatshirt", 19.99));
    	products.add(new Product(1002L, "Cargo Pants", 29.99));
    	products.add(new Product(1003L, "Blue Jeans", 33.99));
        products.add(new Product(1004L, "Hoodie", 39.99));
        products.add(new Product(1005L, "12pk Socks", 9.99));
        products.add(new Product(1006L, "Beanie", 17.99));
    }
    
    public List<Product> getProducts() {
    	return products;
    }
    
    public Optional<Product> getProductById(Long id) {
    	return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
