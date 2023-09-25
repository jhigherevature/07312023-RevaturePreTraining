package com.revature.animals;

public class Animal {
	private String species;
	private String name;
	private int age;
	public Animal() {
		super();
	}

	// This constructor will be used for Constructor Injection for our Bean
	public Animal(String species, String name, int age) {
		super();
		System.out.println("Parameterized Constructor Called - Animal Class");
		this.species = species;
		this.name = name;
		this.age = age;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		System.out.println("Setter Method Called - species");
		this.species = species;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Setter Method Called - name");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("Setter Method Called - age");
		this.age = age;
	}
	@Override
	public String toString() {
		return "Animal [species=" + species + ", name=" + name + ", age=" + age + "]";
	}
}
