package com.tca.entites;

import java.util.Scanner;

public class Student {

	private Integer rno;
	private String name;
	private Float per;
	
	public void display()
	{
		System.out.println("Rno  : " + rno);
		System.out.println("Name : " + name);
		System.out.println("Per  : " + per);
	}
	
	public void accept()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the  roll no. : ");
		rno = sc.nextInt();
		
		System.out.print("Enter  the   name   : ");
		name = sc.next();
		
		System.out.print("Enter the percentage: ");
		per = sc.nextFloat();
	}
	
}
