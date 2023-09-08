package com.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.testing.basics.A_Calculator;

public class A_TestCalculator {

	private A_Calculator calc;
	
	@Before
	public void setUp() {
		System.out.println("\tBefore Test");
		calc = new A_Calculator();
	}
	
	@After
	public void tearDown() {
		System.out.println("\tAfter Test");
		calc = null;
	}
	
	@Test
	public void testAdd_01() {
		System.out.println("Add Test 01");
		int result = calc.add(1, 2);
		assertTrue(result == 3);
	}
	
	@Test
	public void testAdd_02() {
		System.out.println("Add Test 02");
		int result = calc.add(10, 5);
		assertTrue(result == 15);
	}

	@Test
	public void testAdd_03() {
		System.out.println("Add Test 03");
		int result = calc.add(-9, 200);
		assertTrue(result == 191);
	}
}
