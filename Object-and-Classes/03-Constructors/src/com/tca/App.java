package com.tca;

import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student(101,"AAA", 60.0f);
		Student s3 = new Student(s2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

}
