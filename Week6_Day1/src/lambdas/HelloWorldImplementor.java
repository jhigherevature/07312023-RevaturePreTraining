package lambdas;

public class HelloWorldImplementor implements HelloWorldInterface {

	@Override
	public void sayHello() {
		System.out.println("Hello World! - Implementing Class");
	}
}
