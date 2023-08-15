package solid.lsp;

/*
 * This class Demonstrates a correct example of the "Liskov Substitution Principle" (LSP)
 * from the SOLID Design principles
 */
public class Correct {
	class Bird {
	    void flapWings() { }
	}

	class Sparrow extends Bird {
	    @Override
	    void flapWings() {
	        // Implementation for Sparrow Flapping wings - this may result in flight
	    }
	}

	class Penguin extends Bird {
		@Override
		void flapWings() {
			// Implementation for Penguin Flapping Wings - this won't result in flight, but may swimming
		}
	}

	class BirdHandler {
	    void makeBirdFlap(Bird bird) {
	        bird.flapWings(); // This should be correct for all subclasses of Bird
	    }
	}
}
