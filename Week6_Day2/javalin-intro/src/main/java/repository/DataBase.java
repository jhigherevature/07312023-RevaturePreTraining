package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Product;

/*
 * This class is acting as a stand-in for our entire Database layer (DAO and DB)
 * We will incorporate the entirety of our application next time...
 */
public class DataBase {
	// This list represents a 'Product' table that would exist in our database
	private List<Product> myProducts;

	// This int variable is a stand-in for a serial (auto-increment) id value
	private int idGenerator = 0;

	// When we create our Database we will create a new empty list to hold our products
	public DataBase() {
		super();
		myProducts = new ArrayList<Product>();
	}

	// This setup method gives us some initial values to play with in our program
	public void setupDatabase() {
		Collections.addAll(myProducts, 
				new Product(++idGenerator, "Sweatshirt", 19.99),
				new Product(++idGenerator, "Cargo Pants", 29.99), 
				new Product(++idGenerator, "Blue Jeans", 33.99),
				new Product(++idGenerator, "Hoodie", 39.99), 
				new Product(++idGenerator, "12pk Socks", 9.99),
				new Product(++idGenerator, "Beanie", 17.99));
	}

	// DAO Method Stand-ins
	public List<Product> getMyProducts() {
		return myProducts;
	}

	public Product getProductById(long id) {
		for (Product p : myProducts)
			if (p.getProductId() == id)
				return p;

		return null;
	}

	public Product addProduct(Product product) {
		product.setProductId(++idGenerator);
		myProducts.add(product);

		return product;
	}

	public Product updateProduct(Product product) {
		boolean itemFound = false;
		for (Product p : myProducts)
			if (p.getProductId() == product.getProductId()) {
				itemFound = true;
				p.setProductName(product.getProductName());
				p.setProductPrice(product.getProductPrice());
			}

		return itemFound ? product : null;
	}

	public Product deleteProduct(long id) {
		Product p = null;
		for (int i = 0; i < myProducts.size(); i++)
			if (myProducts.get(i).getProductId() == id) {
				p = myProducts.get(i);
				myProducts.remove(i);
			}
		return p;
	}
}
