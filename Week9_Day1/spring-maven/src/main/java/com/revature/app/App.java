package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.animals.Animal;
import com.revature.animals.AnimalConfig;
import com.revature.animals.Owner;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		// The 'getBean' method, when supplied with the Bean id, will return a generic Object...you must cast or use the overloaded getBean() method
		// Animal anim = (Animal)appContext.getBean("animal1");
		Animal anim1 = appContext.getBean("animal1", Animal.class);
		System.out.println(anim1);
		
		Animal anim2 = appContext.getBean("animal2", Animal.class);
		System.out.println(anim2);
		
		Owner own = appContext.getBean(Owner.class);
		System.out.println(own);
		
		ApplicationContext javaContext = new AnnotationConfigApplicationContext(AnimalConfig.class);
		Animal javaAnim = javaContext.getBean(Animal.class);
		System.out.println(javaAnim);
	}
}
