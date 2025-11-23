package com.tca;

public class App {

	public static void main(String[] args) {

		/*
		 Primitive data types are :
		 		byte
		 		boolean
		 		short
		 		int
		 		long
		 		float
		 		double
		 		char
		 		
		 */
		
		byte b = 1;
		boolean bool = true;
		short s = 101;
		int i = 21;
		long l = 22112312312312231l;
		float f = 90.23f;
		double d = 2321123123122.3123122;
		char ch = 'A';
		
		System.out.println("Byte    : " + b + " , MAX : " + Byte.MAX_VALUE + " MIN : " + Byte.MIN_VALUE);
		System.out.println("Boolean : " + bool + " , TRUE : " + Boolean.TRUE + " FALSE : " + Boolean.FALSE);
		System.out.println("Short   : " + s + " , MAX : " + Short.MAX_VALUE + " MIN : " +Short.MIN_VALUE);
		System.out.println("Int     : " + i + " , MAX : " + Integer.MAX_VALUE + " MIN : " + Integer.MIN_VALUE);
		System.out.println("Long    : " + l + " , MAX : " + Long.MAX_VALUE + " MIN : " + Long.MIN_VALUE);
		System.out.println("Float   : " + f + " , MAX : " + Float.MAX_VALUE + " MIN : " + Float.MIN_VALUE);
		System.out.println("Double  : " + d + " , MAX : " + Double.MAX_VALUE + " MIN : " + Double.MIN_VALUE);
		System.out.println("Char    : " + ch + " , MAX : " + Character.MAX_VALUE + " MIN : " + Character.MIN_VALUE);
		
		
	}

}
