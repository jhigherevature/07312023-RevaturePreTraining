package com.testing.injection;

public class B_ConstructorInjection {
	private B_AppData data;
	
	public B_ConstructorInjection(B_AppData data) {
		System.out.println("Constructor Injection - Constructor Called");
		this.data = data;
	}
	
	public boolean execute(int value) {
		return data.performTask(100);
	}
}
