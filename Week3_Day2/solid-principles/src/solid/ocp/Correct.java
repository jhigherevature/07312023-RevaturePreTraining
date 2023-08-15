package solid.ocp;

/*
 * This class Demonstrates a correct example of the "Open/Closed Principle" (OCP)
 * from the SOLID Design principles
 */
public class Correct {
	void animalSound(Animal animal) {
			animal.makeSound();
	}
	
	abstract class Animal {
		abstract void makeSound();
	}

	class Dog extends Animal {
		@Override
		void makeSound() {
			System.out.println("Woof");
		}
	}

	class Cat extends Animal {
		@Override
		void makeSound() {
			System.out.println("Meow");
		}
	}
}

