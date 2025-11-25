package com.tca.util;

public class ArrayAlgo {

	public static <T extends Comparable> Pair<T> minMax(T... arr){ 
		if(arr == null || arr.length < 1) return null;
		
		T min = arr[0];
		T max = arr[0];
		
		for(int i = 0; i < arr.length; ++i) {
			if(min.compareTo(arr[i]) > 0) min = arr[i];
			if(max.compareTo(arr[i]) < 0) max = arr[i];
		}
		
		return new Pair<T>(min, max);
	}
}
