package solid.isp;

/*
 * This class Demonstrates a correct example of the "Interface Segregation Principle" (ISP)
 * from the SOLID Design principles
 */
public class Correct {
	interface Eater {
	    void eat();
	}

	interface Swimmer {
	    void swim();
	}

	class Hippo implements Eater, Swimmer {
	    @Override
	    public void eat() {
	        // Hippo eating logic
	    }

	    @Override
	    public void swim() {
	        // Hippo sleeping logic
	    }
	}

	class Robot {

	}

}
