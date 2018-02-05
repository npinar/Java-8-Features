package com.nevzat.defaultmethods;

@FunctionalInterface
public interface MyFunctionalInterface {

	//functional interface must contain only one abstract method
	double calculate(int num);

    default double sqrt(double num) {
        return Math.sqrt(num);
    }
}
