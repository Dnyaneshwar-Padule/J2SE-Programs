package com.tca.util;

import java.util.function.Supplier;

public class Pair <T> {
	private T firstValue;
	
	public Pair() {
		firstValue = null;
	
		/*
		 we can not do like new T()
		 because after type erasure T becomes Object
		 so it will become like
		 new Object()
		 
		 and we don't want object of Object for Type Integer,String,etc.
		 
		 So, what to do, 
		 w can write a static supplier method, which will instantiate T
		 
		 */
		
	}
	
	public Pair(T firstValue) {
		this.firstValue = firstValue;
	}

	public T getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(T firstValue) {
		this.firstValue = firstValue;
	}
	
	public static <T> Pair<T> makePair(Supplier<T> constr) {
		return new Pair<>(constr.get());
	}
	
	
	// Old style to instantiate Generic class
	public static <T> Pair<T> createPair(Class<T> c){
		try {
			return new Pair<>(c.getConstructor().newInstance());
		}
		catch(Exception e) {
			return null;
		}
	}
	
}
