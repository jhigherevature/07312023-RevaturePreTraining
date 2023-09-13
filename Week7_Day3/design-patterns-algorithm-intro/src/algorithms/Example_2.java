package algorithms;

public class Example_2 {
	/*
	 * Prompt : Create an algorithm that will check is a word is a palindrome. The
	 * 		algorithm should accept string input and return a boolean.
	 * 
	 * 
	 * Pseudocode:
	 * FUNCTION isPalindrome(str: STRING) -> BOOLEAN:
	 * 		// Maybe we should add steps to verify considering casing of letters... 		
	 * 		SET left = 0
	 * 		SET right = length of str - 1
	 * 
	 * 		WHILE left < right:
	 * 			IF char at index left IS NOT EQUAL TO char at index right:
	 * 				RETURN FALSE
	 * 			INCREMENT left
	 * 			DECREMENT right
	 * 		RETURN TRUE
	 */
	public boolean isPalindrome(String str) { // racecar
		// Maybe we should add steps to verify considering casing of letters...
		
		int left = 0;
		int right = str.length() - 1;
		
		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			
			left++;
			right--;
		}
		return true;
	}
}
