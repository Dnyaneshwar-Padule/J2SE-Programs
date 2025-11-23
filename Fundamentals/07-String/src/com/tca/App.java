package com.tca;

public class App {

	public static void main(String[] args) {

		/*
		   In java, we can create Strings dynamically with the help of
		   String, StringBuilder and StringBuffer classes
		   
		   -- String class is not mutable.
		   -- StringBuilder and StringBuffer are mutable 
		   -- StringBuilder is Asynchronous
		   -- StringBuffer is Synchronous
		   
		 */
		
		String str1 = "Athrva";
		String str2 = "Athrva";
		/*
		 When we create a string like this, 
		 the string literal is Stored in the String Constant Pool
		 If there are same string, then it references to the same object
		 
		 ex. 
		 
		 	String str1 = "Athrva"
		 	String str2 = "Athrva"
		  
		  String "Athrva" is same, so str1 and str2 reference to the same string 
		  which is in the string constant pool
		  
		 */
		
		String str3 = new String("Manoj");
		String str4 = new String("Manoj");
		/*
			Here, the String is created on the heap, in a object
			here, it always creates a new object for string
		 */
		
		System.out.println("String 1 : " + str1);
		System.out.println("String 2 : " + str2);
		System.out.println("String 3 : " + str3);
		System.out.println("String 4 : " + str4);

		System.out.println("Address of String 1 : " + System.identityHashCode(str1));
		System.out.println("Address of String 2 : " + System.identityHashCode(str2));
		System.out.println("Address of String 3 : " + System.identityHashCode(str3));
		System.out.println("Address of String 4 : " + System.identityHashCode(str4));
		
		System.out.println("str1 == str 2 : " + ( str1 == str2));
		System.out.println("str3 == str 4 : " + ( str3 == str4));
		
	}

}
