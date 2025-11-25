package com.tca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		DataInputStream dataInputStream = null;
		DataOutputStream dataOutputStream = null;
		
		try {
			serverSocket = new ServerSocket(1024);
			System.out.println("Server is started !");
			socket = serverSocket.accept();
			System.out.println("Client is connected !");
			System.out.println("Client data !");
			System.out.println("Connection port : " + socket.getLocalPort());
			System.out.println("Client IP address :" + socket.getInetAddress());
			System.out.println("Local address : " + socket.getLocalAddress());
			System.out.println("Remote socket address : " + socket.getRemoteSocketAddress());
			System.out.println("-------------------------------------------------------------");
			
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Message fromm client : " + dataInputStream.readUTF());
			System.out.println("Exit..........");
			
			dataInputStream.close();
			dataOutputStream.close();
			socket.close();
			serverSocket.close();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
