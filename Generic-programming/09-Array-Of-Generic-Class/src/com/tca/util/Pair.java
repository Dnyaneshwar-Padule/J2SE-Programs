package com.tca.util;

public class Pair <T> {
	private T firstValue;
	
	public Pair() {
		firstValue = null;
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
	
}
