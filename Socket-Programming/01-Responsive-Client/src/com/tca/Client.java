package com.tca;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Client is started !");
			socket = new Socket("localhost", 1024);
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			
			while(true) {
				System.out.print("Send a message (Enter 'STOP' to exit ): ");
				String msg = br.readLine();
				dataOutputStream.writeUTF( msg);
				if(msg.equals("STOP")) break;
			}
			
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
