package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsingMaps {
	public static void main(String[] args) {
//		useMap();
		countLetters("Javalin");
		
		/*
		 * Note: We can gain incredible Flexibility (albeit with considerably
		 * more complexity) in how we store data using Maps, especially when
		 * combined with other data structures:
		 */
		Map <Integer, ArrayList<String>> listMap;
		Map <String, Map<String, Integer>> complexMap;
		Map <Integer, String[]> arrMap;
	}
	
	
	
	
	public static void useMap() {
		System.out.println("::: MAPS :::");
		Map<String, Double> map = new HashMap<String, Double>();
		
		// use 'put' to add a key-value pair to the map
		map.put("Java", 11.0);
		map.put("C#", 6.0);
		map.put("Python", 3.12);
		map.put("Postgresql", 15.4);
		 
		System.out.println("Keys");
		for (String k : map.keySet() )
			System.out.print(k + "\t");
		
		System.out.println("\nValues");
		for (Double v : map.values() )
			System.out.print(v + "\t");
		
		// use remove to delete entries using the key to find the entry
		map.remove("Python");
		
		/*
		 * Note : the 'replace' method effectively does the following:
		 *  if (map.containsKey(key)) {
		 *		return map.put(key, value);
		 *	} else
		 *  	return null;
		 *	}
		 */
		map.replace("Java", 17.0);
		
		System.out.println("===== AFTER REMOVAL AND REPLACE =====");
		System.out.println("Keys");
		for (String k : map.keySet() )
			System.out.print(k + "\t");
		
		System.out.println("\nValues");
		for (Double v : map.values() )
			System.out.print(v + "\t");
	}
	
	// This method just shows how maps can be used to solve problems...
	public static void countLetters(String input) {
		// The Character is a letter, the Integer is the count of that letter...
		HashMap<Character, Integer> map = new HashMap<>();
		
		String word = input;
		char[] characters = word.toCharArray();

		for (int i = 0; i < word.length(); i++) {
			if (map.containsKey(characters[i])) {
				map.put(characters[i], map.get(characters[i]) + 1);
			} else {
				map.put(characters[i], 1);
			}
		}
		System.out.println("Input: " + input);
		System.out.println(map);
	}
}
