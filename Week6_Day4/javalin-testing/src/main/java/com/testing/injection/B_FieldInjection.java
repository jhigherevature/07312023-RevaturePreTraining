package com.testing.injection;

public class B_FieldInjection {
	// This is an 'initializer' block. It will run when an object is created in memory
	{
		System.out.println("Field Injection - Initializer Block Run");
	}
	private B_AppData data;
	
	public boolean execute(int value) {
		return data.performTask(value);
	}
}
