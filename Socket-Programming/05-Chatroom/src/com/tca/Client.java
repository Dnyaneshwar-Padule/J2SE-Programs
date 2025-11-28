package com.tca;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.tca.util.MessageReceiver;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			socket = new Socket("localhost", 1024);
			
			System.out.println("Connected to chat-room !");
			 
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
		
			Thread messageReceiver = new Thread(new MessageReceiver(inputStream));
			messageReceiver.start();
			
			
			String buffer;
			while(true) {
				//System.out.print("Enter : ");
				buffer = br.readLine();
				
				if(buffer.toUpperCase().equals("STOP")) 
					break;
				else if(buffer.isBlank())
						continue;
				
				outputStream.writeUTF(buffer);
			}
			
			messageReceiver.interrupt();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
