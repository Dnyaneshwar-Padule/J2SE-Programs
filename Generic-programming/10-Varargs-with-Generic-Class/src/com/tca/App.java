package com.tca;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.tca.util.ArrayAlg;

public class App {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<Integer>();
		ArrayAlg.addAll(nums, 1,2,3,4,5,6,7,8,9,10);
	
		try {			
			String a = String.class.getConstructor(String.class).newInstance("AAA");
		
			System.out.println(a);

			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
