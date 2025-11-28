package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.tca.util.MessageReceiver;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			socket = new Socket("localhost", 1024);
			
			System.out.println("Connected to chat-room !");
			 
			in  = new BufferedReader( new InputStreamReader( socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true); // auto flush
		
			Thread messageReceiver = new Thread(new MessageReceiver(in));
			messageReceiver.start();
			
			
			String buffer;
			while(true) {
				//System.out.print("Enter : ");
				buffer = br.readLine();
				
				if(buffer.toUpperCase().equals("STOP")) 
					break;
				else if(buffer.isBlank())
						continue;
				
				out.println(buffer);
			}
			
			messageReceiver.interrupt();
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
