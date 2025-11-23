package com.tca;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in); // Scanner object to take input from the console
		int num = 0;
		
		System.out.print("Enter a number : ");
		num = sc.nextInt();
		
		System.out.println("Entered Number : " + num);
		
		sc.close();	
	}

}
