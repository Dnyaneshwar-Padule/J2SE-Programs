package com.tca.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.tca.Server;

public class ClientHandler implements Runnable {
	private Socket socket;
	private int clientId;
	private PrintWriter outputStream;
	
	public ClientHandler(Socket socket, int clientId) {
		if(socket == null)
			throw new IllegalArgumentException("Socket can not be null");
		this.socket = socket;
		this.clientId = clientId;
	}

	public PrintWriter getWriter() {
		return outputStream;
	}

	@Override
	public void run() {
		
		try(BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream()))){
			outputStream = new PrintWriter(socket.getOutputStream(), true);
			Server.broadcast(this, "Client " + clientId + " is connected.");
			Server.addClient(this);
			outputStream.println("You are connected to chatroom !\nEnter 'STOP' to exit.");
			
			String buffer;
			while(true) {
				buffer = in.readLine();
				if(buffer.toUpperCase().equals("STOP"))
					break;
				Server.broadcast(this, "Client " + clientId + ": " + buffer );
			}
			outputStream.println("Disconnected...");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Server.removeClient(this);
			System.out.println("\u001B[31mClient " + clientId + " is disconnected !\u001B[0m");
			Server.broadcast(this, "Client " + clientId + " is disconnected !");			
		}
	}
	
}
