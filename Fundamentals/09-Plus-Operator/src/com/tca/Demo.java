package com.tca;

public class Demo {

	public static void main(String[] args) {

		String a = "abc";
		String b = "abc";
		String c = "xyz";
		
		String ab = new String("abc");
		String cd = new String("abc");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(ab);
		System.out.println(cd);
		
		System.out.println("Address of a : " + System.identityHashCode(a));
		System.out.println("Address of b : " + System.identityHashCode(b));
		System.out.println("Address of c : " + System.identityHashCode(c));
		System.out.println("Address of ab : " + System.identityHashCode(ab));
		System.out.println("Address of cd : " + System.identityHashCode(cd));
		
		
		
	}

}
