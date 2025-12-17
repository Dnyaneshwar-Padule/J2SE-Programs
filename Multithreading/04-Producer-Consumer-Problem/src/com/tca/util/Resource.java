package com.tca.util;

import java.util.LinkedList;

public class Resource {
	private LinkedList<Long> res;
	private int capacity;
	private long productCount;
	
	public Resource(int capacity) {
		if(capacity < 1)
			throw new IllegalArgumentException("Capacity is too low.");
		
		this.capacity = capacity;
		productCount = 0;
		res = new LinkedList<Long>();
	}
	
	public void produce() throws InterruptedException{
		//Always produce product
		while(true) {			
			synchronized (this) {
				//If capacity is full, wait till consumer consumes the product
				while(res.size() == capacity)
					wait(); // release the lock
				
				res.add(productCount);
				
				System.out.println("\033[32mProducer produced : " + productCount + "\033[0m");
				productCount++;
				//Notify Consumer thread, to consume the produced product
				notify();
			}
			Thread.sleep(450); // sleep for 450 milliseconds
		}
	}
	
	public void consume() throws InterruptedException {
		long product;
		//Always consume
		while(true) {
			synchronized (this) {
				//If there is no product, wait till producer produces product
				while(res.size() == 0)
					wait(); // release the lock
				
				product  = res.remove();
				
				System.out.println("\033[33mConsumer consumed : " + product + "\033[0m");
				
				//notify the producer thread to producer more products
				notify();
			}
			Thread.sleep(450);
		}
	}
		
}

/*
 
 	wait():
 		we can't write wait() outside the synchronized() block, 
 		because, wait() internally does two things, 
 			1. release the acquired lock (monitor)
 			2. Then put the thread into the waiting the thread
 		If we write wait() outside the lock, the thread won't own a lock, so JVM will throw an exception
 		
 	notify() / notifyAll():
 		Same rule is for these methods
 		These methods, wakes up the threads which are in waiting state, to access the same resource 
 		but if, the current thread, won't own a lock, then how can it tell other threads that, it is releasing the lock, come and own it
 		So in this case, JVM will again throw exception 

  
 */ 
