package com.tca;

import com.tca.util.ArrayAlg;

public class App {

	public static void main(String[] args) {
		
		//It works even if we don't specify the type, like there in first case
		System.out.println("Mid : " + ArrayAlg.getMid(1,2,4,5,6));
		System.out.println("Mid : " + ArrayAlg.<String>getMid("ab", "cd", "ef", "gh"));
	}
	
}
