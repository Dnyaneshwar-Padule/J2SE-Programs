package com.tca;

import com.tca.util.ConsumerThread;
import com.tca.util.Resource;

public class App {

	public static void main(String[] args) {
		Resource resource = new Resource(5);
		
		ConsumerThread consumerThread = new ConsumerThread(resource);
		ProducerThread producerThread = new ProducerThread(resource);
		
		consumerThread.start();
		producerThread.start();
	}

}