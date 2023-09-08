package com.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.testing.injection.B_AppData;
import com.testing.injection.B_ConstructorInjection;
import com.testing.injection.B_FieldInjection;
import com.testing.injection.B_SetterInjection;


/*
 * When injecting data, the following will occur:
 * 	1-Test will create the mock data (@Mock)
 * 	2-Test will create the objects which need to be given the mock data (@InjectMocks)
 * 	3-Field | Constructor | Setter Injection will occur
 */
public class B_InjectionTests {
	
	// We will inject mock data into this object
	@InjectMocks
	B_ConstructorInjection conInject;
	
	// We will inject mock data into this object
	@InjectMocks
	B_SetterInjection setInject;
	
	// We will inject mock data into this object
	@InjectMocks
	B_FieldInjection fieldInject;
	
	// This is the data we are mocking
	@Mock
	B_AppData data;
	
	@Before
	public void setUp() {
		// The 'openMocks' method will perform injection across all of our specified fields
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void constructorInjectionTest_1() {
		System.out.println(":: Constructor Test 1 ::");
		
		Mockito.when(data.performTask(100)).thenReturn(true);
		
		boolean result = conInject.execute(100);
		assertTrue(result);
	}
	
	@Test
	public void constructorInjectionTest_2() {
		System.out.println(":: Constructor Test 2 ::");
		Mockito.when(data.performTask(1)).thenReturn(false);
		boolean result = conInject.execute(1);
		assertFalse(result);
	}
	
	@Test
	public void setterInjectionTest_1() {
		System.out.println(":: Setter Test 1 ::");
		Mockito.when(data.performTask(100)).thenReturn(true);
		boolean result = setInject.execute(100);
		assertTrue(result);
	}
	
	@Test
	public void setterInjectionTest_2() {
		System.out.println(":: Setter Test 2 ::");
		Mockito.when(data.performTask(1)).thenReturn(false);
		boolean result = setInject.execute(1);
		assertFalse(result);
	}
	
	@Test
	public void fieldInjectionTest_1() {
		System.out.println(":: Field Test 1 ::");
		Mockito.when(data.performTask(100)).thenReturn(true);
		boolean result = fieldInject.execute(100);
		assertTrue(result);
	}
	
	@Test
	public void fieldInjectionTest_2() {
		System.out.println(":: Field Test 2 ::");
		Mockito.when(data.performTask(1)).thenReturn(false);
		boolean result = fieldInject.execute(1);
		assertFalse(result);
	}
}

