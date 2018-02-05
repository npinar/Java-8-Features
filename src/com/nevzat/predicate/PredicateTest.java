package com.nevzat.predicate;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class PredicateTest {

	@Test
	void predicate_examples() {
		
		Predicate<String> name = (input) -> input.equals("nevzat");
		
		assertFalse(name.test("pinar"));
		assertTrue(name.test("nevzat"));
	}
}
