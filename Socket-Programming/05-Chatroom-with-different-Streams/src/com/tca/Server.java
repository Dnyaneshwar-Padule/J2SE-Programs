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
			System.out.println("\u001B[32mChatroom is open now....\u001B[0m");
			System.out.println("\u001B[93mWaiting for clients !\u001B[0m");
			

			int client = 0;
			
			while(true) {
				Socket socket = server.accept();
			
				new Thread(new ClientHandler(socket, ++client)).start();
				System.out.println("\u001B[32mClient " + client + " is connected !\u001B[0m");
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
	            		client.getWriter().println("\u001B[95m" +message + "\u001B[0m");
	            } catch (Exception e) {
	                // ignore dead clients
	            }
	        }
	    }
	}
}


/*
System.out.println("\u001B[30m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[31m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[32m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[33m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[34m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[35m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[36m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[37m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[90m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[91m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[92m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[93m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[94m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[95m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[96m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[97m" + "Rahul joined" + "\u001B[0m");
System.out.println("\u001B[1mBold Text\u001B[0m");
System.out.println("\u001B[30;1;4mUnderlined Text\u001B[0m");

*/