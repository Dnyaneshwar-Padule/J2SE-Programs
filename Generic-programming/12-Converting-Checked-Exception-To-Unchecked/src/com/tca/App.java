package com.tca;

import com.tca.util.Task;

public class App {

	public static void main(String[] args) throws InterruptedException {
				
		new Thread(() -> {
			try{
				Thread.sleep(100);
				System.out.println("Running...");
			}
			catch(Exception e) {
				Task.<RuntimeException>throwAs(e);
			}
			
		}).start();
				
		System.out.println("END");
		
	}
}
