package com.tca;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		Pair<Integer> pair1 = new Pair<>(2,3);
		Pair<String> pair2 = new Pair<>("Dnyaneshwar", "Computer Science");
		
		//No need to cast return type, compiler knows the return type is the specified type <Integer>, <String>
		System.out.println("Pair 1, first value  : " + pair1.getFirstVal());
		System.out.println("Pair 1, second value : " + pair1.getSecondVal());
		
		System.out.println("Pair 2, first value  : " + pair2.getFirstVal());
		System.out.println("Pair 2, second value : " + pair2.getSecondVal());
		
	}
	
}
