package com.revature.model;

public class Product {
    private Long id;
    private String name;
    private Double itemPrice; 

    public Product(Long id, String name, Double itemPrice) {
        this.id = id;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", itemPrice=" + itemPrice + "]";
	}
    
}

