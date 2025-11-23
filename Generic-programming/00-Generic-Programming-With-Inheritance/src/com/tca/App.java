/*
	The concept of generics was introduced for the first time in Java 5.
	However, the Collection Framework has been available since JDK 1.2.

	Before generics, the Collection Framework used inheritance to achieve a kind of generic programming.
	Since every class in Java implicitly inherits from the Object class, 
	the old collections were designed to accept and return values of type Object.

	Because of this, developers could add any type of object into collections like ArrayList.
	But the main problem appeared when retrieving elements: the returned value was of type Object,
	so the programmer had to explicitly cast it to the required type.
	If the casting was invalid, it caused a ClassCastException at runtime.

	The following example demonstrates how generic-like behavior 
	was achieved using inheritance before Java introduced real generics.
*/

package com.tca;

import com.tca.util.MyLinkedList;

public class App {
	
	public static void main(String[] args) {

		
		MyLinkedList list = new MyLinkedList();
		
		list.insertAtBegin(1);
		list.insert("Dnyaneshwar", 2);
		
		System.out.println("Int : " + (Integer)list.get(1));    // no problem
		System.out.println("String : " + (String)list.get(2));  // no problem
		
		//System.out.println("Name : " + (String)list.get(1));   // ClassCastException
		
		
	}
	
}
