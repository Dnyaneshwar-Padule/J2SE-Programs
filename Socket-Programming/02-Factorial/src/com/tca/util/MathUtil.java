package com.tca.util;

public class MathUtil {

	public static int factorial(int num) {
		int factorial = 1;
		while(num > 0)
			factorial *= num--;
		return factorial;
	}
}
