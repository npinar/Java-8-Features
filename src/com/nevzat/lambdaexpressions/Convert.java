package com.nevzat.lambdaexpressions;

@FunctionalInterface
public interface Convert<A,B> {

	B convertFromTo(A input);
}
