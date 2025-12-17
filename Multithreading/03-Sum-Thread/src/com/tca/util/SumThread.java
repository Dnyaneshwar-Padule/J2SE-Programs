package com.tca.util;

public class SumThread extends Thread {

	private int arr[];
	private int startIndex;
	private int endIndex;
	private long sum;
	
	public SumThread(int[] arr, int startIndex, int endIndex) {
		this.arr = arr;
		this.endIndex = endIndex;
		this.startIndex = startIndex;
		this.sum = 0;
	}

	@Override
	public void run() {
		sum = 0; 
		for(int i = startIndex; i <= endIndex; i++)
			sum += arr[i];
	}
	
	public long getSum() {
		return sum;
	}
	
}
