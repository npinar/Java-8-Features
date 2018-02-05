package com.nevzat.defaultmethods;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MyFunctionalInterfaceTest {

	@Test
	void test_default_method_sqrt_for_valid_results() {
		
		//sqrt is a default method in functional interface
		//implementing as anonymous class
		MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {

			@Override
			public double calculate(int num) {
				return sqrt(num);
			}
		};
		
		assertEquals(3, myFunctionalInterface.calculate(9));
		assertEquals(4, myFunctionalInterface.calculate(16));
	}

}
