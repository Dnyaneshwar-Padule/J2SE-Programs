package com.tca.util;

/*
 	Generics In Java are very similar to C++ Templates
 */

/*
 	 It is common practice to use uppercase letters for type variables, and to keep
 	them short. The Java library uses the variable E for the element type of a
 	collection, K and V for key and value types of a table, and T (and the
 	neighboring letters U and S, if necessary) for “any type at all.”
 */

//Now, Pair class can store data of similar T
public class Pair<T> {

	private T firstVal;
	private T secondVal;
	
	public Pair(){
		firstVal = null;
		secondVal = null;
	}
	
	public Pair(T firstVal, T secondVal) {
		this.firstVal = firstVal;
		this.secondVal = secondVal;
	}

	public T getFirstVal() {
		return firstVal;
	}

	public void setFirstVal(T firstVal) {
		this.firstVal = firstVal;
	}

	public T getSecondVal() {
		return secondVal;
	}

	public void setSecondVal(T secondVal) {
		this.secondVal = secondVal;
	}
	
}
