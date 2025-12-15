package com.tca.util;

import java.util.Arrays;

public class Bank {
	private double accounts[];

	public Bank(int n, double initialAmount) {
		if( n < 2)
			throw new IllegalArgumentException("Too few accounts.");
		accounts = new double[n];
		Arrays.fill(accounts, initialAmount);
	}
	
	public synchronized void transfer(int from, int to, double amount) {
		if(accounts[from] < amount) return; 
	
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance()); 
	}
	
	public double getTotalBalance() {
		double balance = 0;
		
		for(double amount : accounts)
			balance += amount;
		return balance;
	}
	
	public int size() {
		return accounts.length;
	}
}
