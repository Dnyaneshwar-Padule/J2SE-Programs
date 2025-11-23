package com.tca;

public class App {

	public static void main(String[] args) {
		/*
		 	In java there are two types of Reference data types
		 		1. Object Reference Type
		 		2. Array Reference Type
		 */
		
		int[] arr = new int[3];
		/*
		 	Here, arr is array refernce varaible, and new int[3] is actual array on the heap
		 	arr is created on the stack, which holds reference of array
		 */
		
		Integer i = new Integer(10);
		
		/*
		 Here, i is the object reference varaible, and new Integer(10) is the actual object created on the heap
		 i, is created on the stack, and it holds the reference of the object (which is on heap)
		 */
		
		System.out.println("Reference held by arr : " + arr); // arr.hashCode()
		System.out.println("Reference held by i : " + i); // i.hashCode()
		
	}

}
