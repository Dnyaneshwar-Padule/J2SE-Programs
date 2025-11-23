package com.tca.util;

/*
 	T is the type of first value
 	U is the type of second value
 */
public class Pair<T, U> {
	private T firstVal;
	private U secondVal;
	
	public Pair() {
		firstVal = null;
		secondVal = null;
	}
	
	public Pair(T firstVal, U secondVal) {
		this.firstVal = firstVal;
		this.secondVal = secondVal;
	}
	
	public T getFirstVal() {
		return firstVal;
	}
	
	public void setFirstVal(T firstVal) {
		this.firstVal = firstVal;
	}
	
	public U getSecondVal() {
		return secondVal;
	}
	
	public void setSecondVal(U secondVal) {
		this.secondVal = secondVal;
	}
	
}
