package com.tca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
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
			
			long size = 0;
			long bytesSent = 0;
			
			try {
				
				FileInputStream fis = new FileInputStream(fileName);
				File file = new File(fileName);
				size = file.length();
				
				byte buffer[] =  new byte[8192 * 1024];
				int bytesRead;
				
				while( (bytesRead = fis.read(buffer)) != -1 ) {
					bytesSent += bytesRead;
					outputStream.write(buffer, 0, bytesRead);
					System.out.println( (((double)bytesSent/(double)size)*100) + "%" );
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
