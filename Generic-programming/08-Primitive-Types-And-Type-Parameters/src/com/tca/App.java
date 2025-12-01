package com.tca;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		// We can not use primitive data types as Type parameters
		
		// invalid
		//Pair<int, double> pair = new Pair<>();

		/*
		 This is due to erasure
		 After erasure, all Type Parameters are replaced by Object class
		 But we can not use Object class for primitive data type
		 But Wrapper classes extend from Object class, so they can be used
		 
		 */
		
		
		
		// Using Wrapper classes as Type parameters
		Pair<Integer, Double> pair = new Pair<>();
		
		pair.setFirstValue(25);
		pair.setSecondValue(355.0);
		
		System.out.println("\033[32m First Value : " + pair.getFirstValue());
		System.out.println("Second value : " + pair.getSecondValue() + "\033[0m");
	}
}
