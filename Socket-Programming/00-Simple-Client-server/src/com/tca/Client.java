package com.tca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		
		try {
			System.out.println("Client is started !");
			socket = new Socket("localhost", 1024);
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			
			System.out.println("Sending message to the server !");
			dataOutputStream.writeUTF("Hello, welcome to socket programming using Java !");
			
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
