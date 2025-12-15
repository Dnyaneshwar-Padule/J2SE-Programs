package com.tca;

public class App {

	public static void main(String[] args) throws Exception{
		ChatUser low = new ChatUser("Low Priority Thread");
		ChatUser high = new ChatUser("Hight Priority Thread");
		ChatUser normal = new ChatUser("Normal Priority Thread");
		
		low.setPriority(Thread.MIN_PRIORITY);
		high.setPriority(Thread.MAX_PRIORITY);
		normal.setPriority(Thread.NORM_PRIORITY);
		
		
		low.start();
		high.start();
		normal.start();
		
		Thread.sleep(2000);
		System.out.println("\nSuspending ChatUser : normal");
		normal.mySuspend();
		
		Thread.sleep(2000);
		System.out.println("\nResuming ChatUser : normal");
		normal.myResume();
		
		Thread.sleep(2000);
		System.out.println("\nStopping ChatUser : low");
		low.myStop();
		
		low.join();
		normal.join();
		high.join();
		
		System.out.println("\nFinal Thread Status : ");
		System.out.println("Low Alive ? " + low.isAlive());
		System.out.println("Normal Alive ? " + normal.isAlive());
		System.out.println("High Alive ? " + high.isAlive());
	}

}
