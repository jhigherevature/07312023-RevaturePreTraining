package app;

import controller.Controller;
import io.javalin.Javalin;

public class App {
	public static void main(String[] args) {
		
		// Create Javalin App
		Javalin app = Javalin.create();
		
		// set up a 'Hello World' endpoint
		app.get("/", ctx -> ctx.result("Hello World!"));
		
		// Start the Javalin App using port 8080
		app.start(8080);
		
		// Create our controller
		Controller controller = new Controller();
		
		// setup endpoints in our controller
		controller.setEndpoints(app);
		
		app.get("/sample-area", ctx -> ctx.result("Lets see if we can return this!!"));
	}
}
