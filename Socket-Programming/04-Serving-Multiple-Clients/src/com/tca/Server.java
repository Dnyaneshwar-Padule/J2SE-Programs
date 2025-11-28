package com.tca;

import java.net.ServerSocket;
import java.net.Socket;

import com.tca.handler.ClientHandler;

public class Server {

	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(1024)){
			System.out.println("Server is started ...");
			System.out.println("Waiting for clients !");
			int client = 0;
			
			while(true) {
				Socket s = server.accept();
				new Thread(new ClientHandler(s, ++client)).start();
				System.out.println("Client is connected with ID : " + client);
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}	
}
