package com.tca;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tca.handler.ClientHandler;

public class Server {

	private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(1024)){
			System.out.println("Chatroom is open now....");
			System.out.println("Waiting for clients !");
			
			int client = 0;
			
			while(true) {
				Socket socket = server.accept();
			
				new Thread(new ClientHandler(socket, ++client)).start();
				System.out.println("Client " + client + " is connected !");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Chat Room is closed !");
		}

	}

	public static void addClient(ClientHandler client) {
		clients.add(client);
	}
	
	public static void removeClient(ClientHandler client) {
		clients.remove(client);
	}
	
	public static void broadcast(ClientHandler sender, String message) {
	    synchronized(Server.clients) {
	        for (ClientHandler client : Server.clients) {
	            try {
	            	if(sender != client)
	            		client.getWriter().println(message);
	            } catch (Exception e) {
	                // ignore dead clients
	            }
	        }
	    }
	}

	
	
}
