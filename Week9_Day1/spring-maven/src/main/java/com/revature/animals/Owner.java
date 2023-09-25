package com.revature.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// the @Component Annotation identifies an object as a Bean for the IoC container to recognize
@Component
public class Owner {
	Animal anim;
	String name;

	public Animal getAnim() {
		return anim;
	}

	public void setAnim(Animal anim) {
		this.anim = anim;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	public Owner(@Qualifier("animal1") Animal anim, @Value("John") String name) {
		super();
		this.anim = anim;
		this.name = name;
	}

	public Owner() {
		super();
	}

	@Override
	public String toString() {
		return "Owner [anim=" + anim + ", name=" + name + "]";
	}
}
