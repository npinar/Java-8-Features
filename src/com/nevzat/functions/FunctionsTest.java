package com.nevzat.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionsTest {

	@Test
	void simple_function_examples() {
		//Function<T, R> can be used without the need to define a new functional interface every time.
		Function<Integer, String> add = (num) -> Integer.toString(num);
		Assertions.assertEquals("1", add.apply(1));
	}
	

	@Test
	void function_with_andthen() {
		
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), 
			 new Employee("Harry Major", 25),
			 new Employee("Ethan Hardy", 65),
			 new Employee("Nancy Smith", 15),
			 new Employee("Deborah Sprightly", 29));
		
		List<String> empNameList = new ArrayList<>(); 
		List<String> empNameListExpected = new ArrayList<>(Arrays.asList("T", "H", "E", "N", "D"));
		
		Function<Employee, String> names = (Employee e) -> e.getName();
		
		Function<String, String> firstChar = (input) -> input.substring(0, 1);
		
		for(Employee e : employeeList) {
			empNameList.add(names.andThen(firstChar).apply(e));
		}
		Assertions.assertEquals(empNameListExpected, empNameList);
		
	}
}
