package com.testing.injection;

public class B_SetterInjection {
	private B_AppData data;
	
	public boolean execute(int value) {
		return data.performTask(value);
	}
	
	public void setData(B_AppData data) {
		System.out.println("Setter Injection - Setter Called");
		this.data = data;
	}
}
