package com.tca.util;

public class ArrayAlg {

	/*
	 Note that the type variable is declared after modifiers (public static)
	 and before the return type 
	 */
	public static <T> T getMid(T... a) {
		if( a == null) 
			return null;
		return a[ a.length / 2 ];
	}
	
}
