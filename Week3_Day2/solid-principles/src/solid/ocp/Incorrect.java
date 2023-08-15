package solid.ocp;

/*
 * This class Demonstrates an example that violates the "Open/Closed Principle" (OCP)
 * of the SOLID Design principles
 */
public class Incorrect {
	void animalSound(Animal animal) {
		if (animal.type == "Dog")
			System.out.println("Woof");
		else if (animal.type == "Cat")
			System.out.println("Meow");
		else 
			System.out.println("Animal type not recognized");
	}
	
	class Animal {
		String type;
	}
}
