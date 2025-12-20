package com.tca.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandlerThread extends Thread {
	private Socket socket;

	public ClientHandlerThread(Socket socket) {
		if(socket == null)
			throw new IllegalArgumentException("Socket can not be null !");
		this.socket = socket;
	}

	// run method will continuously, accept the client response
	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String response;
			
			while(true) {
				response = in.readLine();
				System.out.println("\033[93m"+ response + "\033[0m");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
