package model;

/*
 * POJO Design Pattern:
 * 		-'Plain Old Java Object'
 * 		-Design pattern to create a very simple and 'standard' java object
 * 			-Private fields
 * 			-Getters and Setters for all fields (typically public)
 * 			-No-argument & Fully parameterized Constructor
 * 			-Override the Object class methods (toString, hashCode, equals)
 * 			-Implement Serializable*
 */
public class Product {
	private long productId;
	private String productName;
	private double productPrice;

	// Constructors
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productId, String productName, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	// getters and setters
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	// Hashcode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (productId ^ (productId >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(productPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
			return false;
		return true;
	}
	
	// toString
	@Override
	public String toString() {
		return "Product [productId=" + productId 
				+ ", productName=" + productName 
				+ ", productPrice=" + productPrice+"]";
	}
}
