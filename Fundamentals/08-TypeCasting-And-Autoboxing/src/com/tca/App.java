package com.tca;

public class App {

	public static void main(String[] args) {

		/*
		 
		 Type Casting :
		  Type casting is when we put a value from a data type to another.
		 	There are two types of Type Casting
		 	1. Implicit Type casting
		 	2. Explicit type casting
		 	
		 	1. Implicit type casting
		 		-- It done automatically but the compiler, without data loss
		 		-- It happens when, we try to typecast a small data type into a large data type
		 			ex. short to int
		 			    int to long 
		 				float to double
		 	
		 	2. explicit type casting
		 		-- It is done by the programmer, it may cause loss of data
		 		-- It is done when we try to put a value in larger data type into a smaller data type
		 			ex. int to short
		 				long to int
		 				double to float
		 				char to short (char is unsigned, short is signed)
		 				
		 
		 
		 Auto boxing : 
		 Autoboxing is when we put a value of primitive data type into it's wrapper class
		 like, int a = 5;
		 		Integer i = new Integer(a);
		 		Integer b = 10;
		 		
		 Unboxing
		 Unboxing is when we get a value from wrapper class and put it into it's primitive data type
		 like, Integer b = new Integer(101);
		 		int i = b.intValue();
		 
		 */
		
		
		int a = 100;
		long l = a; // Implicit Type casting
		
		double d = 1010.12;
		float f = (float)d; // Explicit type casting
		
		Integer num1 = new Integer(a); // auto-boxing
		int num2 = num1.intValue() + 101; // un-boxing
		
		System.out.println(" a : " + a);
		System.out.println(" l : " + l);
		System.out.println(" d : " + d);
		System.out.println(" f : " + f);
		System.out.println(" num1 : " + num1);
		System.out.println(" num2 : " + num2);
		
	}

}
