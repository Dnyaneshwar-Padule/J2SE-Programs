package com.tca;

import com.tca.util.ArrayAlg;
import com.tca.util.Pair;

public class App {
	
	public static void main(String[] args) {
		String a[] = {"Hello", "World", "Welcome", "To", "Java", "Zebra"};
		Pair<String> minMax = ArrayAlg.minmax(a);
		
		System.out.println("Min value : " + minMax.getFirstValue());
		System.out.println("Max value : " + minMax.getSecondValue());
		
	}
	
}
