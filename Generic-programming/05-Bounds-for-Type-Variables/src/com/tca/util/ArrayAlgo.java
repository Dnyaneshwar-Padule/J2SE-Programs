package com.tca.util;

public class ArrayAlgo {

	/*
	 	T extends Comparable...
	 	extends Comparable ??
	 	
	 	But Comparable is an interface, there should be implements !
	 	
	 	Yes Comparable is an interface, but implements is used for a class, 
	 	not Type variable, In java generics extends does not mean it is it's child class
	 	it means, (T) it should be it's sub type
	 	
	 	 For Type variable, we use extends for both class and interface
	 	 we can also use multiple interfaces with '&' between them 
	 	 ex. <T extends Comparable & Serializable>
	 	 
	 	 we can also use class and interface, but class should come first
	 	  
	 */
	public static <T extends Comparable> T min(T... arr) {
		if(arr == null || arr.length < 1) return null;
		T min = arr[0];
		for(int i = 0; i < arr.length; ++i) 
			if(min.compareTo(arr[i]) > 0) min = arr[i];
		return min;
	}
	
}
