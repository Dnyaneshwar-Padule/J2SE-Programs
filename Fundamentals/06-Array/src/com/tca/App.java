package com.tca;

public class App {

	public static void main(String[] args) {
		
		/*
		   In java, there are 3 types of array
		  		1.Single-dimentional Array
		  		2.Multi-dimentional array
		 		3.Jagged Array 
		 */
		
		int[] singleDimentionalArray = {
				1,2,3,4,5,6
		};
		
		int[][] multiDimentionalArray = {
				{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20}
		};
		
		int[][] jaggedArray = {
				{1,2,3,4,5},
				{1,2,3},
				{1,2,3,4},
				{1,2},
				{1}
		};

		System.out.println("Single Dimentional Array : ");
		for(int i = 0; i < singleDimentionalArray.length; i++) {
			System.out.print(singleDimentionalArray[i] + " ");
		}
		System.out.println();
		
		System.out.println("Multi-Dimentional Array :");
		for(int i = 0; i < multiDimentionalArray.length ; i++) {
			for(int j = 0; j < multiDimentionalArray[i].length; j++) {
				System.out.print(multiDimentionalArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Jagged Array : ");
		for(int i = 0; i < jaggedArray.length ; i++) {
			for(int j = 0; j < jaggedArray[i].length; j++) {
				System.out.print(jaggedArray[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
}
