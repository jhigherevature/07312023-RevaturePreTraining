package solid.isp;

/*
 * This class Demonstrates an example that violates the "Interface Segregation Principle" (ISP)
 * of the SOLID Design principles
 */
public class Incorrect {
	interface Animal {
	    void eat();
	    void swim();
	}

	class Rat implements Animal {
	    @Override
	    public void eat() {
	        // Implementation for eating
	    }

	    @Override
	    public void swim() {
	        // Rats are surprisingly good swimmers 
	    }
	}
	
	class Bat implements Animal {
	    @Override
	    public void eat() {
	        // Implementation for eating
	    }

	    @Override
	    public void swim() {
	        // Bats cannot swim - so this is irrelevant here
	    }
	}

}
