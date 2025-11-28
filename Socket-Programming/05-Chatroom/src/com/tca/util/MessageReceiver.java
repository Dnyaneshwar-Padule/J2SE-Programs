package com.tca.util;

import java.io.DataInputStream;

public class MessageReceiver implements Runnable{

	private DataInputStream inputStream;
	
	public MessageReceiver(DataInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	@Override
	public void run() {
		try {
			String msg;
			while(true) {
				msg = inputStream.readUTF();
				System.out.println(msg);
			}
		}
		catch (Exception e) {
		}
	}

}
