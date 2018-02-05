package com.nevzat.lambdaexpressions;

public class Person {

	String firstName;
    String lastName;
    String location;
    
	public Person() {
		
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person(String firstName, String lastName, String location) {
		this(firstName, lastName);
		this.location = location;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
