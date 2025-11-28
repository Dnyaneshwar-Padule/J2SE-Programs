package com.tca.util;

import java.io.BufferedReader;

public class MessageReceiver implements Runnable{

	private BufferedReader in;
	
	public MessageReceiver(BufferedReader inputStream) {
		this.in = inputStream;
	}
	
	@Override
	public void run() {
		try {
			String msg;
			while(true) {
				msg = in.readLine();
				System.out.println(msg);
			}
		}
		catch (Exception e) {
		}
	}

}
