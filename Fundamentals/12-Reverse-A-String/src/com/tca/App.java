package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter a string :");
		String str = br.readLine();
	
		/*
		 String is immutable, can't change it directly with loop
		 */
		
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		
		System.out.println("Using StringBuilder : " + sb);
	
		
	}

}
