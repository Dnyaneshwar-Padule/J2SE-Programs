package com.tca.util;

import java.util.List;

public class ArrayAlg {

	/*
	 	T... ts is var-args
	 	but, it's actually an array of T
	 	
	 	but in java, array of Generics is not allowed...
	 	right..
	 	but Java allowed var-args, it's not safe, but if they don't allow it, 
	 	var-args won't work for generics
	 	
	 	but java gives warnings
	 	
	 */
	
	//This annotation says, This method is safe, don't give warnings
	@SafeVarargs
	public static <T> void addAll(List<T> coll, T... ts){
		for(T t : ts) coll.add(t);
	}
	
}
