package com.nevzat.lambdaexpressions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LamdaExpressionsTest {

	@Test
	void sorting_list_with_lambda_expression() {
		
		List<String> expectedNames = Arrays.asList("alex", "bob", "chris", "ethan", "zee");
		
		//prior to java 8, we had to use anonymous objects
		List<String> names = Arrays.asList("bob", "alex", "ethan", "chris", "zee");
		List<String> namesForJava8 = Arrays.asList("bob", "alex", "ethan", "chris", "zee");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		});
		
		assertIterableEquals(expectedNames, names);
		
		//java 8 we can use lambda expression
		Collections.sort(namesForJava8, (a, b) -> a.compareTo(b));
		Assertions.assertIterableEquals(expectedNames, namesForJava8);
	}

	@Test
	void lambda_expression_functional_interface() {
		
		Convert<String, Integer> convert = (input)-> Integer.valueOf(input);
		
		assertEquals(Integer.valueOf(75013),convert.convertFromTo("75013"));
		
	}
	
	@Test
	void lambda_expression_static_method_reference() {
		
		Convert<String, Integer> convert = Integer::valueOf;
		
		assertEquals(Integer.valueOf(75013),convert.convertFromTo("75013"));
		
	}
	
	@Test
	void lambda_expression_static_method_reference_with_any_method() {
		
		Convert<String, String> getFirstChar = (input) -> ParseInput.startsWith(input);
		assertEquals("M",getFirstChar.convertFromTo("Myinput"));
		
		
		Convert<String, String> convert = ParseInput::startsWith;
		assertEquals("M",convert.convertFromTo("Myinput"));
		
	}
	
	@Test
	void short_cut_objec_creation() {
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("nevzat", "pinar", "dallas");
		assertEquals("nevzat",person.getFirstName());
		assertEquals("pinar",person.getLastName());
		assertEquals("dallas",person.getLocation());
		
	}
	
	@Test
	void accessing_local_variables_from_lambda_expression() {
		
		//number is implicity final, it cannot be assigned to another value, compiler will report error
		//can also access instance variables and static variables
		int number  = 2;
		
		Convert<String, Integer> convert = (input)-> Integer.valueOf(input + number);
		assertEquals(Integer.valueOf(750132),convert.convertFromTo("75013"));
	}
	
}
