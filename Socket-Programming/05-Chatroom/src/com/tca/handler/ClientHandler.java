package com.tca.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.tca.Server;

public class ClientHandler implements Runnable {
	private Socket socket;
	private int clientId;
	private DataOutputStream dataOutputStream;
	
	public ClientHandler(Socket socket, int clientId) {
		if(socket == null)
			throw new IllegalArgumentException("Socket can not be null");
		this.socket = socket;
		this.clientId = clientId;
	}

	public DataOutputStream getDataOutputStream() {
		return dataOutputStream;
	}

	@Override
	public void run() {
		
		try(DataInputStream dataInputStream = new DataInputStream(socket.getInputStream())){
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			Server.broadcast(this, "Client " + clientId + " is connected.");
			Server.addClient(this);
			dataOutputStream.writeUTF("You are connected to chatroom !\nEnter 'STOP' to exit.");
			
			String buffer;
			while(true) {
				buffer = dataInputStream.readUTF();
				if(buffer.toUpperCase().equals("STOP"))
					break;
				Server.broadcast(this, "Client " + clientId + ": " + buffer );
			}
			dataOutputStream.writeUTF("Disconnected...");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				dataOutputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Server.removeClient(this);
			System.out.println("Client " + clientId + " is disconnected !");
			Server.broadcast(this, "Client " + clientId + " is disconnected !");			
		}
	}
	
}
