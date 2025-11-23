package com.tca;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a String : ");
		String str = sc.next();
		
		System.out.println("String : " + str);
		System.out.println("Printing every character :");
		for(int i = 0; i < str.length(); i++)
			System.out.println(str.charAt(i));
		
	}

}
