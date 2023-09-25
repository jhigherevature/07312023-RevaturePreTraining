package com.revature.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
	/*
	 * If we want to name a bean, we can specify a value for a 'name' annotation property:
	 * @Bean(name="beanName")
	 */
	@Bean
	public Animal getRandomAnimals() {
		List<Animal> animals = new ArrayList<Animal> ();
		animals.add( new Animal("cat", "Mr. Fluffles", 2) );
		animals.add( new Animal("dog", "Chow Chow", 5) );
		animals.add( new Animal("fish", "Nemo", 1) );
		
		return animals.get( new Random().nextInt(animals.size()) );
	}
}
