package com.tca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		
		try {
			
			server = new ServerSocket(1024);
			System.out.println("Server is started.");
			System.out.println("Waiting for client !");
			socket = server.accept();
			System.out.println("Client is connected !");
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			String fileName = inputStream.readUTF();
			System.out.println("Requested file : " + fileName);
			
			try {
				
				FileInputStream fis = new FileInputStream(fileName);
				byte buffer[] =  new byte[8192];
				int bytesRead;
				
				while( (bytesRead = fis.read(buffer)) != -1 ) {
					outputStream.write(buffer, 0, bytesRead);
				}
				
				// Send remaining bytes...
				outputStream.flush();
				fis.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("File is sent !");
			
			socket.close();
			server.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
