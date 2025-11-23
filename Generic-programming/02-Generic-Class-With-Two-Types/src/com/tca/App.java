package com.tca;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		Pair<String, Integer> pair1 = new Pair<>("Dnyaneshwar", 19);
		Pair<Double, String> pair2 = new Pair<>(91.80, "Athrva");
		
		System.out.println("Pair1, first value  : " + pair1.getFirstVal());
		System.out.println("Pair1, second value : " + pair1.getSecondVal());
		System.out.println("Pair2, first value  : " + pair2.getFirstVal());
		System.out.println("Pair2, second value : " + pair2.getSecondVal());
		
	}
	
}
