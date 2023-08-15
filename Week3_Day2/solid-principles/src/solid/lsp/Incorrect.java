package solid.lsp;

/*
 * This class Demonstrates an example that violates the "Liskov Substitution Principle" (LSP)
 * of the SOLID Design principles
 */
public class Incorrect {
	class Bird {
	    void fly() { }
	}
	
	class Penguin extends Bird {
		@Override
		void fly() {
			throw new UnsupportedOperationException("Penguins can't fly!");
		}
	}
}
