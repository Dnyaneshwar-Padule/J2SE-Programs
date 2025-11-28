package com.tca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.tca.util.MathUtil;

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
			
			int num = 0;
			try {
				
				num = Integer.parseInt( inputStream.readUTF() );
				System.out.println("Requested factorial of : " + num);
				outputStream.writeUTF( Integer.toString( MathUtil.factorial(num) ) );
			}catch(NumberFormatException ne) {
				System.out.println("Bad request from client !");
				outputStream.writeUTF("BAD_REQUEST");
			}
			
			socket.close();
			server.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
