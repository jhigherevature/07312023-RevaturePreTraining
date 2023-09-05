package lambdas;

/*
 * Functional Interfaces are interfaces in Java with a single abstract method (not a single method)
 */
@FunctionalInterface
public interface HelloWorldInterface {
	public void sayHello();
	
	// the keyword 'default' in interfaces allow you to provide an implementation for the method
	public default void secondMethod() { System.out.println("This is an implemented interface method"); }
}
