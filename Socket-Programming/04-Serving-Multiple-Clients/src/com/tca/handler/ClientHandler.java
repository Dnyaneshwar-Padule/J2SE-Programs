package com.tca.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {

	private Socket socket;
	int clientId;
	
	public ClientHandler(Socket socket, int clientId ) {
		if(socket == null)
				throw new IllegalArgumentException("Socket can not be null !");
		this.clientId = clientId;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try(DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())	){
			
			outputStream.writeUTF("Enter 'STOP' to exit...");
			
			while(true) {
				String request = inputStream.readUTF();
				if(request.toUpperCase().equals("STOP")) break;
				System.out.println("Client " + clientId + ": " + request);
				outputStream.writeUTF(request.toUpperCase());
				
			}
			outputStream.writeUTF("Disconnected..");
		}
		catch (Exception e) {
//			e.printStackTrace();
		}
		finally {
			try { socket.close(); }
			catch(Exception e) {}			
			System.out.println("Client " + clientId + " is disconnected !");
		}
	}

}
