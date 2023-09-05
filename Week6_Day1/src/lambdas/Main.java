package lambdas;

public class Main {
	public static void main(String[] args) {
		HelloWorldInterface hwiObj = new HelloWorldImplementor();
		greetSomeone(hwiObj);
		
		HelloWorldInterface lambda = () -> { 
			System.out.println("Hello World! - Lambda"); 
		};
		
		greetSomeone(lambda);
		
		
		
		greetSomeone( 
				() -> { System.out.println("Hello World! - I was implemented in the argument!");
				System.out.println("Hello World! - I was implemented in the argument!");
				System.out.println("Hello World! - I was implemented in the argument!");
				System.out.println("Hello World! - I was implemented in the argument!");
				System.out.println("Hello World! - I was implemented in the argument!");
				System.out.println("Hello World! - I was implemented in the argument!");
				}
			);
	}
	
	public static void greetSomeone(HelloWorldInterface hwi) {
		hwi.sayHello();
	}
}
