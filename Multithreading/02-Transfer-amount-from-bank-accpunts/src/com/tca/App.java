package com.tca;

import com.tca.util.Bank;

public class App {

	public static final int MAX_AMOUNT = 1000;
	public static final int DELAY = 10;
	public static final int STEPS = 100;
	
	public static void main(String[] args) {
		Bank bank = new Bank(4, 100000);
		
		System.out.println("Initial balance : " + bank.getTotalBalance());
		
		Runnable taskOne = () ->{
			try {
				for(int i = 0; i < STEPS; ++i) {
					double amount = MAX_AMOUNT * Math.random();
					System.out.print("\033[32m");
					bank.transfer(0, 1, amount);
					System.out.print("\033[0m");
					Thread.sleep( (long) (DELAY * Math.random() ));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		Runnable taskTwo = () ->{
			try {
				for(int i = 0; i < STEPS; ++i) {
					double amount = MAX_AMOUNT * Math.random();
					System.out.print("\033[33m");
					bank.transfer(2, 3, amount);
					System.out.print("\033[0m");
					Thread.sleep( (long) (DELAY * Math.random() ));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		};
		
		
		Thread threadOne = new Thread(taskOne);
		Thread threadTwo = new Thread(taskTwo);
		
		threadOne.start();
		threadTwo.start();
		
	}

}
