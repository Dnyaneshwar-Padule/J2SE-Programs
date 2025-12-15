package com.tca.util;

public class PrintTextThread extends Thread {
	private String msg;
	private int n;
	
	public PrintTextThread(String msg, int n) {
		super(msg);
		this.msg = msg;
		this.n = n;
	}
	
	public void run() {
		try {
			for(int i = 0; i < n; i++) {
				System.out.println(msg);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
}
