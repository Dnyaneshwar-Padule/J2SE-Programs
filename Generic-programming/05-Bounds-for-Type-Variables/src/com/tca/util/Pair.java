package com.tca.util;

public class Pair<T> {

	private T firstValue;
	private T secondValue;
	
	public Pair() {
		firstValue = null;
		secondValue = null;
	}
	
	public Pair(T firstValue, T secondValue) {
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
	
	public T getSecondValue() {
		return secondValue;
	}
	
	public void setSecondValue(T secondValue) {
		this.secondValue = secondValue;
	}
	
}
