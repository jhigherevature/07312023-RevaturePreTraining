package com.revature.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean, DisposableBean {

	public void customInit() {
		System.out.println("Custom Init Method called");
	}
	
	public void customDestroy() {
		System.out.println("Custom Destroy Method called");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("@PostConstruct called");
	}

	// 
	@Override
	public void afterPropertiesSet() {
		System.out.println("InitializingBean's afterPropertiesSet called");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy called");
	}

	@Override
	public void destroy() {
		System.out.println("DisposableBean's destroy called");
	}

	// this represents our bean being used in the application
	public void doWork(int i) {
		for (i = Math.abs(i) ; i > 0; i--) System.out.println("Bean is Doing work...");
	}
}
