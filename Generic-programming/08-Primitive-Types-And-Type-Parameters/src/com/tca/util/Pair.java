package com.tca.util;

public class Pair <T,U> {
	private T firstValue;
	private U secondValue;
	
	public Pair() {
		firstValue = null;
		secondValue = null;
	}
	
	public Pair(T firstValue, U secondValue) {
		super();
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public T getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(T firstValue) {
		this.firstValue = firstValue;
	}

	public U getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(U secondValue) {
		this.secondValue = secondValue;
	}
	
	
	
}
