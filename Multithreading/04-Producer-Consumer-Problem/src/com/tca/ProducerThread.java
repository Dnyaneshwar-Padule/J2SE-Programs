package com.tca;

import com.tca.util.Resource;

public class ProducerThread extends Thread {
	private Resource resource;
	
	public ProducerThread(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {		
		try {
			resource.produce();
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
}
