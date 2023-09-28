package com.revature.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.revature.model.Product;

@Repository
public class ProductRepository {
	private final List<Product> products = new ArrayList<>();
	
	Map<Long, Product> mapOfProducts = new HashMap<Long, Product> ();
	
	private Long productSerialId = 1000L;
	
	public ProductRepository () {
        // Initializing with some data
    	products.add(new Product(productSerialId++, "Sweatshirt", 19.99));
    	products.add(new Product(productSerialId++, "Cargo Pants", 29.99));
    	products.add(new Product(productSerialId++, "Blue Jeans", 33.99));
        products.add(new Product(productSerialId++, "Hoodie", 39.99));
        products.add(new Product(productSerialId++, "12pk Socks", 9.99));
        products.add(new Product(productSerialId++, "Beanie", 17.99));
	}
	
    public List<Product> findAll() {
    	return products;
    }
    
    public Optional<Product> findById(Long id) {
    	return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
    
    public Optional<Product> save(Product p) {
    	p.setId(productSerialId++);
    	products.add(p);
    	return Optional.of(p);
    }
    
    public Optional<Product> update(Product p) {
    	for (int i = 0; i < products.size(); i++) {
    		if (products.get(i).getId().equals(p.getId()))
    			products.set(i, p);
    	}
    	
    	return Optional.of(p);
    }
    
    public void deleteById(Long id) {
    	for (int i = 0; i < products.size(); i++) {
    		if (products.get(i).getId().equals(id)) {
    			products.remove(i);
    			break;
    		}
    	}
    }
}
