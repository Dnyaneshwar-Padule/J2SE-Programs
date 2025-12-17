package com.tca;

import com.tca.util.SumThread;

public class App {

	public static void main(String[] args) {
		
		try {
			int nums[] = {10,20,30,40,50,60,70,80,90,100};
			
			SumThread t1 = new SumThread(nums, 0, nums.length / 2);
			SumThread t2 = new SumThread(nums, (nums.length / 2) + 1, nums.length - 1 );
			
			t1.start();
			t2.start();
			
			//Resume main thread, after completion of sum Threads
			t1.join(); 
			t2.join();
			
			System.out.println("Total : " + (t1.getSum() + t2.getSum()));			
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
	}

}
