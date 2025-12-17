package com.tca.util;

public class ConsumerThread extends Thread{
	private Resource resource;
	
	public ConsumerThread(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		try {
			resource.consume();
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
}
