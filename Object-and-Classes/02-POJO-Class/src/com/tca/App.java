package com.tca;

import com.tca.entites.Student;

public class App {

	public static void main(String[] args) {

		Student s = new Student();
		
		s.setName("Athrva");
		s.setRno(38);
		s.setPer(91.60f);
		
		System.out.println("Rno  : " + s.getRno());
		System.out.println("Name : " + s.getName());
		System.out.println("Per  : " + s.getPer());
		
	}

}
