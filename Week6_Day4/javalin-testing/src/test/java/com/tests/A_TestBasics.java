package com.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class A_TestBasics {
	/*
	 * The @BeforeClass annotation marks a method to be invoked one time
	 * prior to running any @Before methods
	 * 
	 * '@BeforeClass' methods should be static
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("\t\tBefore Class Method");
	}
	
	/*
	 * The @AfterClass annotation marks a method to be invoked one time
	 * after running the last @After method after all tests have run
	 * 
	 * '@AfterClass' methods should be static
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("\t\tAfter Class Method");
	}
	
	/*
	 * The @Before annotation marks a method to be invoked prior to running
	 * each @Test method
	 */
	@Before
	public void setUp() {
		System.out.println("\tBefore Test");
	}
	
	/*
	 * The @After annotation marks a method to be invoked after running each
	 * @Test method
	 */
	@After
	public void tearDown() {
		System.out.println("\tAfter Test");
	}
	
	/*
	 * The @Test annotation marks a method as a Test to be run.
	 */
	@Test
	public void testMethod_01() {
		System.out.println("Test Method 01 - Pass");		
		assertTrue(true);
	}
	
	@Test
	public void testMethod_02() {
		System.out.println("Test Method 02 - By default, tests will pass");
	}
	
	/* 
	 * The 'fail' method will cause a test to fail.
	 * 
	 * It is useful to add a 'fail' call to all newly created tests, so you know that there is a test
	 * which still requires implementation
	 */
	@Ignore // '@Ignore' will cause JUnit to skip a test
	@Test
	public void testMethod_03() {
		System.out.println("Test Method 03 - Fail");
		fail("This test will fail");
	}
	
	/*
	 * There are multiple ways to test for Exceptions (see 'A_TestProblemChild' for more details)
	 * 
	 * An easy way is to use the '@Test' annotation...you can optionally provide a value to the annotation
	 * when you are expecting a specific type of exception
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testMethod_04() {
		System.out.println("Test Method 04 - Exception Expected");
		int[] nums = {};
		System.out.println(nums[5]);
	}
}
