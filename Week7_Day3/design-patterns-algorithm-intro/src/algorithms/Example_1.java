package algorithms;

public class Example_1 {
	/*
	 * Prompt : Write an algorithm which prints the 
	 * 	indexes of all odd elements in a given array
	 * 
	 * Pseudocode:
	 * Input: array of ints
	 * Output: none to program 
	 * printing odds value indexes to the console 
	 * 
	 * if array is not null
	 *	 for each element of array
	 * 		if value in the array at the current index is odd	
	 * 			print value of array at the index
	 */
	public static void printOdds(int[] numbers) {
		if(numbers != null) {
			for(int i = 0; i <numbers.length; i++) {
				if(numbers[i] % 2 != 0) { 
					System.out.println(i);
				}
			}
		}
	}
}
