package com.tca.util;

public class Pair <T>{

	private T firstValue;
	private T secondValue;
	
	public Pair(T firstValue, T secondValue) {
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
	
	/*
	
	This method is not allowed, because after erasure, 
	this method will look like 
	public boolean equals(Object t)
	
	and Object class already has same method signature
	
	so, we can't have two methods with same method signature
	
	so, what to do ?
	->Just change the method name
	
	@Override
	public boolean equals(T t) {
		return false;
	}
	 */
	
	public boolean equalsValue(Pair<T> p) {
		return (this.firstValue.equals(p.firstValue) && this.secondValue.equals(p.secondValue) );	
	}

}
