package com.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.testing.basics.A_ProblemChild;

public class A_TestProblemChild {
	
	public static A_ProblemChild pc;
	
	@BeforeClass
	public static void setup () {
		pc = new A_ProblemChild();
	}
	
	@Test
	public void problemMethodTest_01() {
		// you can use the 'assertThrows' method to test if a method throws an exception 
		assertThrows(Exception.class, () -> pc.problematic());		
	}
	
	@Test
	public void problemMethodTest_02() {
		// The 'assertThrows' method will return the exception which a method has thrown 
		Exception e = assertThrows(Exception.class, () -> pc.moreProblematic(true));
		
		// You can use this to do further testing...such as verifying the correct type of Exceptions are being thrown
		assertTrue(e instanceof SQLException);
	}
	
	/*
	 * This test is actually malformed....
	 */
	@Test
	public void problemMethodTest_03() {
		List<Integer> testList = new ArrayList<Integer> ();
		testList.add(15);
		testList.add(1);
		testList.add(5);
		
		List<Integer> actual = pc.badSort(testList);
		
		Collections.sort(testList);
		assertEquals(testList, actual);
	}
	
	/*
	 * This is how 'problemMethodTest_03 should be formed...
	 */
	@Test
	public void problemMethodTest_04() {
		List<Integer> testList = new ArrayList<Integer> ();
		testList.add(15);
		testList.add(1);
		testList.add(5);
		List<Integer> actual = pc.badSort(testList);
		List<Integer> expected = new ArrayList<Integer>();
		expected.addAll(testList);
		Collections.sort(expected);
		assertEquals(expected, actual);
	}
}
