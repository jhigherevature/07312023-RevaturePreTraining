package controller;

import io.javalin.Javalin;
import service.ProductService;

/*
 * Our Controller is used to map our endpoints to associated functionality
 * within our application (this will point to service methods)
 */
public class Controller {
	
	ProductService service;
	
	public void setEndpoints(Javalin app) {
		service = new ProductService();

		app.get("/products", ctx -> service.getAllProducts(ctx));
		app.get("/products/{id}", service::getProductById);
		app.post("/products", service::addNewProduct);
		app.put("/products/{id}", service::updateProductById);
		app.delete("/products/{id}", service::deleteProductById);
	}
}
