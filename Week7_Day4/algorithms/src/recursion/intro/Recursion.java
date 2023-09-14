package recursion.intro;

public class Recursion {
	public static void main(String[] args) {
		System.out.println("Iteration:");
		printNumbersWithLoop(10);
		
		System.out.println("Recursion:");
		printNumbersWithRecursion(10);
	}
	
	public static void printNumbersWithLoop(int n) {
		if (n<= 0)
			System.out.println(0);
		
		for (int i = n; i > 0; i--)
			System.out.println(i);
	}
	
	public static int printNumbersWithRecursion(int n) {
		if (n <= 0) {
			return 0;
		}
		
		System.out.println(n);
		
		return printNumbersWithRecursion(--n);
	}
}
