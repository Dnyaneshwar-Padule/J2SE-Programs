package com.tca;

import java.util.ArrayList;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		/*
		 You Cannot Create Arrays of Parameterized Types
 		You cannot instantiate arrays of parameterized types, such as
 		
 			var table = new Pair<String>[10]; // ERROR
 			
 		What’s wrong with that? After erasure, the type of table is Pair[]. You can
 		
 			convert it to Object[]:
 			Object[] objarray = table;
 			
 		An array remembers its component type and throws an ArrayStoreException
 		if you try to store an element of the wrong type:
 		
 			objarray[0] = "Hello"; // ERROR--component type is Pair
 			
 		But erasure renders this mechanism ineffective for generic types. The
 		assignment
 		
 			objarray[0] = new Pair<Employee>();
 			
 		would pass the array store check but still result in a type error. For this
 		reason, arrays of parameterized types are outlawed.
		
		Note that only the creation of these arrays is outlawed. You can declare a
 		variable of type Pair<String>[]. But you can’t initialize it with a new
 				Pair<String>[10]
		 */
	
		
		
//		 Not allowed
//		var table = new Pair<String>[10];
		
		
		// allowed but dangerous
		
		Pair<String> table[] =  (Pair<String>[]) new Pair<?>[10]; 
	
	
		table[0] = new Pair(10); // allowed
		/*
		 But it will throw exception on calling getter on table[0]
		 ClassCastException
		 */
		
		
		//But we can easily use an List
		// for ex.
		ArrayList<Pair<String>> t  = new ArrayList<Pair<String>>();
		t.add(new Pair<String>("s"));
		
		// invalid
		//t.add(new Pair<Integer>(23));
		
	}
}
