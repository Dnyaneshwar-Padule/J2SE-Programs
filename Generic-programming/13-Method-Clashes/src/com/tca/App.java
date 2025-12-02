package com.tca;

import com.tca.util.Pair;

public class App {

	public static void main(String[] args) {
		
		Pair<Integer> a = new Pair<>(1, 2);
		Pair<Integer> b	 = new Pair<Integer>(1, 2);
		Pair<Integer> c	 = new Pair<Integer>(2,3);
		
		System.out.println(a.equalsValue(b));
		System.out.println(a.equalsValue(c));
		
	}
}
