package com.revature.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifecycleApp {
	public static void main(String[] args) {
		System.out.println("::: APPLICATION START :::");
		
		ConfigurableApplicationContext beanContext = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		showBeanLifecycle(beanContext, 10);
		
		beanContext.close();
		
		System.out.println("::: APPLICATION END :::");
	}
	
	public static void showBeanLifecycle(ApplicationContext beanContext, int count) {
		beanContext.getBean(MyBean.class).doWork(count);
	}
}
