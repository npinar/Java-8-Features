package com.nevzat.lambdaexpressions;

public interface PersonFactory<P extends Person> {
	
	 P create(String firstName, String lastName, String location);
}