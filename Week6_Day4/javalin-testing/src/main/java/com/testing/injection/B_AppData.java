package com.testing.injection;

public class B_AppData {
	/*
	 * This method performs an arbitrary task, but is simply being used to showcase Injection with Mockito
	 * 
	 * See 'B_InjectionTests.java' for more details... 
	 */
	public boolean performTask(Integer arg) {
		return arg > 10 ? true : false;
	}
}
